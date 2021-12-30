//package com.example.userservice.swagger;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.bind.annotation.RequestMethod;
//import springfox.documentation.builders.ApiInfoBuilder;
//import springfox.documentation.builders.PathSelectors;
//import springfox.documentation.builders.RequestHandlerSelectors;
//import springfox.documentation.builders.ResponseMessageBuilder;
//import springfox.documentation.schema.ModelRef;
//import springfox.documentation.service.ApiInfo;
//import springfox.documentation.service.Contact;
//import springfox.documentation.service.ResponseMessage;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spring.web.plugins.Docket;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import static springfox.documentation.builders.PathSelectors.regex;
//
////@Configuration
////@EnableSwagger2
//public class SwaggerConfiguration {
//
//    private String version = "V1";
//    private String title = "Ecommerce User";
//
//    @Bean
//    public Docket api() {
//        List<ResponseMessage> responseMessages = new ArrayList<ResponseMessage>();
//        responseMessages.add(new ResponseMessageBuilder().code(200).message("OK !!!").build());
//        responseMessages.add(new ResponseMessageBuilder().code(500).message("서버 문제 발생 !!!").responseModel(new ModelRef("Error")).build());
//        responseMessages.add(new ResponseMessageBuilder().code(404).message("페이지를 찾을 수 없습니다 !!!").build());
//
//        return new Docket(DocumentationType.SWAGGER_2)
//                .apiInfo(apiInfo()).groupName(version).select()
//                .apis(RequestHandlerSelectors.any())
//                .paths(PathSelectors.any()).build()
//                .useDefaultResponseMessages(false) // responseMessages 설정 적용
//                .globalResponseMessage(RequestMethod.GET,responseMessages);
//    }
//
//
//    private ApiInfo apiInfo() {
//        return new ApiInfoBuilder().title(title)
//                .description("<h3>CRISTOVAL API Reference for Developers</h3>Swagger를 이용한 GuestBook API<br><img src=\"imgName.png\">")
//                .contact(new Contact("CRISTOVAL", "https://cistoval.com", "cristoval@gmail.com"))
//                .license("CRISTOVAL License")
//                .licenseUrl("https://www.cristoval.com/etc/webPrivacy.jsp")
//                .version("1.0").build();
//    }
//
//}