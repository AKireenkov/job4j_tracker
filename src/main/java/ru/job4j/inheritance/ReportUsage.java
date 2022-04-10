package ru.job4j.inheritance;

public class ReportUsage {
    public static void main(String[] args) {
        TextReport report = new TextReport();
        String text = report.generate("Report's name", "Report's body");
        System.out.println(text);

        HtmlReport html = new HtmlReport();
        String text2 = html.generate("Report's name", "Report's body");
        System.out.println(text2);

        JSONReport json = new JSONReport();
        String text3 = json.generate("Report's name", "Report's body");
        System.out.println(text3);
    }
}
