package com.example.utils;

import io.jsonwebtoken.*;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * ClassName:
 * Description:
 * date: 2019/8/27 0027 13:18
 *
 * @author SS
 * @since JDK 1.8
 */
public class JwtTokenUtils {

    public static final String TOKEN_HEADER = "Authorization";
    public static final String TOKEN_PREFIX = "Bearer ";

    private static final String SECRET = "jwtsecretdemo";
    private static final String ISS = "echisan";

    // 角色的key
    private static final String ROLE_CLAIMS = "rol";

    // 过期时间是3600秒，既是1个小时
    private static final long EXPIRATION = 3600L;

    // 选择了记住我之后的过期时间为7天
    private static final long EXPIRATION_REMEMBER = 604800L;


    // 创建token   获取当前等了用户的Token值
    public static String createToken(String username,String role, boolean isRememberMe) {

        // 创建payload的私有声明（根据特定的业务需要添加，如果要拿这个做验证，一般是需要和jwt的接收方提前沟通好验证方式的）
        Map<String, Object> claims = new HashMap<>();
        //设置权限
        claims.put(ROLE_CLAIMS, role);
        //按照指定过期时间段设置过期时间
        long expiration = isRememberMe ? EXPIRATION_REMEMBER : EXPIRATION;
        Date date = new Date(System.currentTimeMillis() + expiration * 1000);


        return Jwts.builder()      //签名算法        //密钥
                .setClaims(claims)                          // 如果有私有声明，一定要先设置这个自己创建的私有的声明，这个是给builder的claim赋值，
                                                               // 一旦写在标准的声明赋值之后，就是覆盖了那些标准的声明
                .signWith(SignatureAlgorithm.HS512, SECRET) // 设置签名使用的签名算法和签名使用的秘钥
                .setIssuer(ISS)                             // 签发者
                .setSubject(username)                       // 主题 代表这个JWT的主体，即它的拥有者，这个是一个json格式的字符串，
                                                               // 可以存放什么userid，roldid之类的，作为什么用户的唯一标志
                .setIssuedAt(new Date())                    // 签发时间
                //.setNotBefore(new Date())                   // 失效时间
                .setExpiration(date)                        // 设置过期时间
                .compact();                                 // 压缩为Jwt标准格式
        /*
          eyJhbGciOiJIUzUxMiJ9                 smark: header 头部
          eyJpc3MiOiJlY2hpc2FuIiwic3ViIjoi5byg5LiJIiwiaWF0IjoxNTY2OTU2MTgwLCJuYmYiOjE1NjY5NTYxODAsImV4cCI6MTU2NzU2MDk4MH0  smark: Claims 包含你想要签署的任何信息
          xpDs0XSOGOnhHIwcOnWPvYWKb0YzcOQQUcjPSAhzRRvvwxS0mObtQz87Pf8UrKshxzONyejS4X4lKm27KmzYMg  smark: 在header中指定的使用该算法的数字签名和声明(加密签名)
        */
    }


    //获取目标用户名
    public static String getUsername(String token) {
        return getTokenBody(token).getSubject();
    }

    // 是否已过期
    public static boolean isExpiration(String token) {
        return getTokenBody(token).getExpiration().before(new Date());
    }

    // 从token中获取用户名||setClaims(claims) 私有声明
    private static Claims getTokenBody(String token) {
        return Jwts.parser()
                .setSigningKey(SECRET)
                .parseClaimsJws(token)
                .getBody();
    }

    // 获取用户角色
    public static String getUserRole(String token){
        return (String) getTokenBody(token).get(ROLE_CLAIMS);
    }

    //校验令牌是否有效

    /*public Boolean validateToken(String token, UserDetails userDetails) {
        JwtUser user = (JwtUser) userDetails;
        String username = getUsername(token);
        return (username.equals(user.getUsername()) && !isTokenExpired(token));
    }*/



    public static void main(String[] args) {

        String jwtResult = createToken("张三", "rol",true);
        String[] split = jwtResult.split("\\.");


        Claims tokenBody = getTokenBody(jwtResult);
        System.out.println(tokenBody);
        //获取Head中签名使用的加密算法
        JwsHeader header = Jwts.parser().setSigningKey(SECRET).parseClaimsJws(jwtResult).getHeader();
        System.out.println();
        //Claims::
        //私有声明+设定用户名称
        // tokenBody = getTokenBody(header);
        //JwsHeader jwsHeader = Jwts.jwsHeader(tokenBody);
        //System.out.println(jwtResult);
        //String username = getUsername(jwtResult);
        //String keyId = Jwts.header().getContentType();
        //System.out.println("头部:"+keyId);
        //System.out.println("私有声明:"+tokenBody);
        //System.out.println("用户名:"+username);
        for (String s : split) {
            System.out.println(s);
        }

    }
}
