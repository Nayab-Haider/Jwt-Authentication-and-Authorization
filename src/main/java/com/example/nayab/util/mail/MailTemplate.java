package com.example.nayab.util.mail;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

@Component
public class MailTemplate {


    private static final Logger log = LogManager.getLogger(MailTemplate.class);

    public String bodyContent(String empName, String messageBody) {
        log.info("Entering ::: class ::: MailTemplate ::: method ::: bodyContent");
        return "<html>" +
                "<head>" +
                "<meta name=\"viewport\" content=\"width=device-width\">" +
                "<style type=\"text/css\" id=\"media-query\">" +
                "body {margin: 0;padding: 0; }table, tr," +
                " td {vertical-align: top;border-collapse: collapse; }.ie-browser table," +
                " .mso-container table {table-layout: fixed; }* {line-height: inherit; " +
                "}a[x-apple-data-detectors=true] {color: inherit !important;text-decoration: none !important; }[owa] " +
                ".img-container div," +
                " [owa] .img-container button {display: block !important; }[owa] .fullwidth button {width: 100% " +
                "!important; }[owa] .block-grid .col {display: table-cell;float: none !important;vertical-align: top;" +
                " }.ie-browser .num12, .ie-browser .block-grid," +
                " [owa] .num12, [owa] .block-grid {width: 500px !important; }.ExternalClass, .ExternalClass p, " +
                ".ExternalClass span, .ExternalClass font, .ExternalClass td, .ExternalClass div {line-height: 100%; " +
                "}.ie-browser .mixed-two-up .num4," +
                " [owa] .mixed-two-up .num4 {width: 164px !important; }.ie-browser .mixed-two-up .num8, [owa] " +
                ".mixed-two-up .num8 {width: 328px !important; }.ie-browser .block-grid.two-up .col, " +
                " [owa] .block-grid.two-up .col {width: 250px !important; }.ie-browser .block-grid.three-up .col," +
                " [owa] .block-grid.three-up .col {width: 166px !important; }.ie-browser .block-grid.four-up .col," +
                " [owa] .block-grid.four-up .col {width: 125px !important; }.ie-browser .block-grid.five-up .col," +
                " [owa] .block-grid.five-up .col {width: 100px !important; }.ie-browser .block-grid.six-up .col, " +
                " [owa] .block-grid.six-up .col {width: 83px !important; }.ie-browser .block-grid.seven-up .col," +
                " [owa] .block-grid.seven-up .col {width: 71px !important; }.ie-browser .block-grid.eight-up .col," +
                " [owa] .block-grid.eight-up .col {width: 62px !important; }.ie-browser .block-grid.nine-up .col," +
                " [owa] .block-grid.nine-up .col {width: 55px !important; }.ie-browser .block-grid.ten-up .col," +
                " [owa] .block-grid.ten-up .col {width: 50px !important; }.ie-browser .block-grid.eleven-up .col, " +
                " [owa] .block-grid.eleven-up .col {width: 45px !important; }.ie-browser .block-grid.twelve-up .col, " +
                " [owa] .block-grid.twelve-up .col {width: 41px !important; }@media only screen and (min-width: " +
                "520px) {.block-grid {width: 500px !important; }.block-grid .col {display: table-cell;Float: none " +
                "!important;vertical-align: top; }.block-grid .col.num12 {width: 500px !important; }.block-grid" +
                ".mixed-two-up .col.num4 {width: 164px !important; }.block-grid.mixed-two-up .col.num8 {width: 328px " +
                "!important; }.block-grid.two-up .col {width: 250px !important; }.block-grid.three-up .col {width: " +
                "166px !important; }.block-grid.four-up .col {width: 125px !important; }.block-grid.five-up .col " +
                "{width: 100px !important; }.block-grid.six-up .col {width: 83px !important; }.block-grid.seven-up " +
                ".col{width: 71px !important; }.block-grid.eight-up .col {width: 62px !important; }.block-grid" +
                ".nine-up .col {width: 55px !important; }.block-grid.ten-up .col {width: 50px !important; }" +
                ".block-grid.eleven-up .col {width: 45px !important; }.block-grid.twelve-up .col {width: 41px " +
                "!important; } }@media (max-width: 520px) {.block-grid, .col {min-width: 320px !important;max-width: " +
                "100% !important; }.block-grid {width: calc(100% - 40px) !important; }.col {width: 100% !important; }" +
                ".col > div {margin: 0 auto; }img.fullwidth {max-width: 100% !important; } }</style>" +
                " </head>" +
                " <body class=\"clean-body\" style=\"margin: 0;padding: 0;-webkit-text-size-adjust: 100%;" +
                "background-color: #FFFFFF\">" +
                " <div class=\"nl-container\" style=\"min-width: 320px;Margin: 0 auto;background-color: #FFFFFF\">" +
                " <div style=\"background-color:#f3f5f7;\">" +
                " <div style=\"Margin: 0 auto;min-width: 320px;max-width: 500px;width: 500px;width: calc(19000% - " +
                "98300px);overflow-wrap: break-word;word-wrap: break-word;word-break: break-word;background-color: " +
                "transparent;\" class=\"block-grid \">" +
                " <div style=\"border-collapse: collapse;display: table;width: 100%;\">" +
                " <div class=\"col num12\" style=\"min-width: 320px;max-width: 500px;width: 500px;width: calc(18000% " +
                "- 89500px);background-color: transparent;\">" +
                " <div style=\"background-color: transparent; width: 100% !important;\">" +
                " <div style=\"border-top: 0px solid transparent; border-left: 0px solid transparent; border-bottom: " +
                "0px solid transparent; border-right: 0px solid transparent; padding-top:5px; padding-bottom:5px; " +
                "padding-right: 0px; padding-left: 0px;\">" +
                " <div style=\"color:#555555;line-height:120%;font-family:Arial, 'Helvetica Neue', Helvetica, " +
                "sans-serif; padding-right: 10px; padding-left: 10px; padding-top: 10px; padding-bottom: 10px;\">" +
                " <div>" +
                " <p style=\"margin: 0;font-size: 12px;line-height: 14px;text-align: center\">" +
                " <span style=\"font-size: 20px; line-height: 24px;\">ProH2R</span>" +
                " </p></div></div></div></div></div></div></div></div>" +
                " <div style=\"background-color:transparent;\">" +
                " <div style=\"Margin: 0 auto;min-width: 320px;max-width: 500px;width: 500px;width: calc(19000% - " +
                "98300px);overflow-wrap: break-word;word-wrap: break-word;word-break: break-word;background-color: " +
                "transparent;\" class=\"block-grid \">" +
                " <div style=\"border-collapse: collapse;display: table;width: 100%;\">" +
                " <div class=\"col num12\" style=\"min-width: 320px;max-width: 500px;width: 500px;width: calc(18000% " +
                "- 89500px);background-color: transparent;\"><div style=\"background-color: transparent; width: 100% " +
                "!important;\">" +
                " <div class=\"bodyContainer\" style=\"border-top: 0px solid transparent; border-left: 0px solid " +
                "transparent; border-bottom: 0px solid transparent; border-right: 0px solid transparent; " +
                "padding-top:5px; padding-bottom:5px; padding-right: 0px; padding-left: 0px;\">" +
                " <div style=\"color:#555555;line-height:120%;font-family:Arial, 'Helvetica Neue', Helvetica, " +
                "sans-serif; padding-right: 10px; padding-left: 10px; padding-top: 10px; padding-bottom: 10px;\">" +
                " <div><p style=\"margin: 0;font-size: 12px;line-height: 14px\">" +
                " <span style=\"font-size: 15px; line-height: 19px;\">Hi <strong>" + empName + "," +
                "</strong></span></p></div></div>" +
                " <!--<div align=\"center\" class=\"button-container center\" style=\"padding-right: 10px; " +
                "padding-left: 10px; padding-top:10px; padding-bottom:10px;\">" +
                " <a href=\"http://www.mylink.com\" target=\"_blank\" style=\"display: inline-block;text-decoration: " +
                "none;-webkit-text-size-adjust: none;text-align: center;color: #ffffff; background-color: #3AAEE0; " +
                "border-radius: 4px; -webkit-border-radius: 4px; -moz-border-radius: 4px; max-width: 135px; width: " +
                "95px; width: auto; border-top: 0px solid transparent; border-right: 0px solid transparent; " +
                "border-bottom: 0px solid transparent; border-left: 0px solid transparent; padding-top: 5px; " +
                "padding-right: 20px; padding-bottom: 5px; padding-left: 20px; font-family: Arial, 'Helvetica Neue', " +
                "Helvetica, sans-serif;mso-border-alt: none\">" +
                " <span style=\"font-size:12px;line-height:24px;\">Confirm Registration</span></a>" +
                " </div>-->" +
                " <div style=\"color:#555555;line-height:120%;font-family:Arial, 'Helvetica Neue', Helvetica, " +
                "sans-serif; padding-right: 10px; padding-left: 10px; padding-top: 10px; padding-bottom: 10px;\">" +
                " <div><p style=\"margin: 0;font-size: 14px;line-height: 17px\">" +
                " <span style=\"font-size: 15px; line-height: 19px;\">" + messageBody + "</span>" +
                " </p>" +
                " <div style=\"color:#555555;line-height:120%;font-family:Arial, 'Helvetica Neue', Helvetica, " +
                "sans-serif; padding-right: 10px; padding-left: 10px; padding-top: 10px; padding-bottom: 10px;" +
                "\"><div><p style=\"margin: 0;font-size: 14px;line-height: 17px\"><br><em>" +
                " <span style=\"text-decoration: underline; font-size: 14px; line-height: 16px;\">" +
                " <span style=\"font-size: 14px; line-height: 16px;" +
                "\"><a href=\"http://www.niletechnologies.com/\">http://www.niletechnologies.com</a></span>" +
                " </span></em></p></div>" +
                " </div>" +
                " <div style=\"padding-right: 10px; padding-left: 10px; padding-top: 10px; padding-bottom: 10px;\">" +
                " <div align=\"center\">" +
                " <div style=\"border-top: 1px solid #BBBBBB; width:100%; line-height:1px; height:1px; font-size:1px;" +
                "\"> </div></div></div></div></div></div></div></div></div>" +
                " <div style=\"background-color:#555555;\"><div style=\"Margin: 0 auto;min-width: 320px;max-width: " +
                "500px;width: 500px;width: calc(19000% - 98300px);overflow-wrap: break-word;word-wrap: break-word;" +
                "word-break: break-word;background-color: transparent;\" class=\"block-grid \">" +
                " <div style=\"border-collapse: collapse;display: table;width: 100%;\"><div class=\"col num12\" " +
                "style=\"min-width: 320px;max-width: 500px;width: 500px;width: calc(18000% - 89500px);" +
                "background-color: transparent;\"><div style=\"background-color: transparent; width: 100% !important;" +
                "\">" +
                " <div style=\"border-top: 0px solid transparent; border-left: 0px solid transparent; border-bottom: " +
                "0px solid transparent; border-right: 0px solid transparent; padding-top:5px; padding-bottom:5px; " +
                "padding-right: 0px; padding-left: 0px;\">" +
                " <div style=\"color:#FFFFFF;line-height:120%;font-family:Arial, 'Helvetica Neue', Helvetica, " +
                "sans-serif; padding-right: 10px; padding-left: 10px; padding-top: 10px; padding-bottom: 10px;\">" +
                " <div><p style=\"margin: 0;font-size: 14px;line-height: 17px;text-align: center\">" +
                " <span style=\"font-size: 12px; line-height: 14px;\">© 2018 Nile Technologies Pvt Ltd. All rights " +
                "reserved.</span>" +
                " </p></div></div></div></div></div></div></div></div></div></body></html>";
    }



}
