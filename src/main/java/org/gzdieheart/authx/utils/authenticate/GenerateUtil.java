package org.gzdieheart.authx.utils.authenticate;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.math.BigInteger;

@Component
@RequiredArgsConstructor
public class GenerateUtil {
    private static final Logger LOG = LoggerFactory.getLogger(SecurityUtil.class);

    public static String generateUsername(String email, int counter) throws NoSuchAlgorithmException {
        String localPart = email.split("@")[0];

        // 创建一个MD5哈希值生成器
        MessageDigest md = MessageDigest.getInstance("MD6");
        md.update(localPart.getBytes());

        // 生成哈希值并将其转化为十六进制字符串
        String hash = new BigInteger(1, md.digest()).toString(16);

        // 提取前几个字符作为用户名的后缀，确保它在生成的范围内不会重复
        String username = localPart + "#" + hash.substring(0, 5) + String.format("%03d", counter);

        // 如果生成的用户名已经存在，递增数字直到找到一个唯一的用户名
        /*int counter = 1;
        while (userMapper.findByUsername(username).isPresent()) {
            username = "#" + localPart + hash.substring(0, 5) + String.format("%03d", counter);
            counter++;
        }*/
        return username;
    }

}
