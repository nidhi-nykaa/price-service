package com.nykaa.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nykaa.file.processor.service.FileProcessorService;
import com.nykaa.file.processor.util.CsvReaderUtil;
/*import com.nykaa.marketplace.cache.AppConfigCache;
import com.nykaa.marketplace.constants.PriceConstants;
import com.nykaa.marketplace.dto.Headers;
import com.nykaa.marketplace.dto.PriceUploadConfig;*/
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class PriceServiceImpl extends FileProcessorService {

    @Override
    public List<Map<String, String>> processRequest(String fileName, InputStream inputStream) {
        //todo : process requests
        String headers = fetchSampleTemplate();
        List<String> csvHeaders = Stream.of(headers.split(",", -1))
                .collect(Collectors.toList());
        List<Map<String, String>> records = CsvReaderUtil.parseCsvFile(csvHeaders, fileName, inputStream);
        return null;
    }

    @Override
    public boolean validateInputRequest(InputStream inputStream) {
        // todo : check validation library/framework
        return false;
    }

    @Override
    public String fetchSampleTemplate() {
        /*PriceUploadConfig priceUploadConfig = AppConfigCache.getSystemConfigOnKey(PriceConstants.databaseKeys.priceConfigKey, PriceUploadConfig.class);
        List<Headers> headersList = priceUploadConfig.getHeaders();
        List<String> headers = new ArrayList<>();
        for (Headers headerData : headersList) {
            headers.add(headerData.getName());
        }
        String csvHeaders = String.join(",", headers);
        return csvHeaders;*/
        return "";
    }

   /* public static void main(String[] args) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        String data =
        "{\"headers\":[{\"name\":\"sku\",\"datatype\":\"string\",\"validators\":\"Nyk.*\"},{\"name\":\"price\",\"datatype\":\"\\\\d*[.]\\\\d+\",\"validators\":\"regex\"}],\"data\":[{\"sku\":\"Nyk12\",\"price\":400},{\"sku\":\"Nyk22\",\"price\":800}]}";
        PriceUploadConfig ob = objectMapper.readValue(data, PriceUploadConfig.class);
        System.out.println(ob.getHeaders().get(0).getValidators());
        boolean b2=Pattern.compile(ob.getHeaders().get(0).getValidators()).matcher(ob.getData().get(0).getSku()).matches();
        System.out.println("datatype chk "+String.valueOf(ob.getData().get(1).getPrice()).matches(ob.getHeaders().get(1).getDatatype()));
        System.out.println("reg chk " +b2);
     *//*
     json for value frm system_property table
     {
 "headers" : [
   {"name" : "sku", "datatype" : "string", "validators" : "regexp"},
   {"name" : "price", "datatype" : "string", "validators" : "regexp"}

],
"data" : [
{
  "sku" : "Nyk123",
  "price" : 300
},
{
  "sku" : "Nyk12344",
  "price" : 500
}
]

}
      *//*
    }

    public static void main2(String[] args) {
        boolean b2=Pattern.compile("Nyk.*").matcher("Nyk123").matches();
        System.out.println(b2);
    }*/
}
