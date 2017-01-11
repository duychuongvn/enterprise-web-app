package com.github.duychuongvn.core.util;

import org.fest.assertions.Assertions;
import org.junit.Test;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.security.GeneralSecurityException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import static org.junit.Assert.*;

/**
 * Created by chuong on 11/01/2017.
 */
public class PasscodeGeneratorTest {
    @Test
    public void generateResponseCode() throws Exception {
        byte[] keyBytes = decodeKey("XZYQCRKEWYV4B7HH435XJ2U7NMTGTRPO");
        final Mac mac = Mac.getInstance("HMACSHA1");
        mac.init(new SecretKeySpec(keyBytes, ""));
        String timeFormat = "yyyy-MM-dd HH:mm:ss";
        DateFormat df = new SimpleDateFormat(timeFormat);
        String datetime = "2016-10-31 20:02:07";
        df.setTimeZone(TimeZone.getTimeZone("GMT+07:00"));

        PasscodeGenerator.Signer signer = new PasscodeGenerator.Signer() {
            @Override
            public byte[] sign(byte[] data) throws GeneralSecurityException {
                return mac.doFinal(data);
            }
        };


        Date dateMinute = df.parse(datetime);
        long optState = dateMinute.getTime() / 30000;
        PasscodeGenerator passcodeGenerator = new PasscodeGenerator(signer, 6);
        String optResult = passcodeGenerator.generateResponseCode(optState);
        Assertions.assertThat(optResult).isEqualToIgnoringCase("972469");


    }

    private static byte[] decodeKey(String secret) throws Base32String.DecodingException {
        return Base32String.decode(secret);
    }

}