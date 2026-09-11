package az.joble;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Main {
    static void main(String[] args) throws Exception {
        String url = "https://lalafo.az/";

        Document document = Jsoup.connect(url)
                .userAgent("Mozilla/5.0")
                .get();

        System.out.println(document.title());

        Elements categories = document.select("[data-component='category-grid-item']");

        System.out.println("Количество категорий: " + categories.size());

        for (Element category : categories) {
            String name = category.select("p").text();
            String link = category.attr("abs:href");

            if (name.equals("Elektronika")) {


                Document document1 = Jsoup.connect(link)
                        .userAgent("Mozilla/5.0")
                        .get();


                Elements categories1 = document1.select("[data-component='category-tab']");
                for (Element category1 : categories1) {
                    String name1 = category1.select("p").text();
                    String link1 = category1.attr("abs:href");

                    if (name1.equals("Mobil telefon və aksesuarlar")) {
                        System.out.println("Подкатегории " + name1);
                        System.out.println("Cсылка " + link1);

                        Document document2 = Jsoup.connect(link1)
                                .userAgent("Mozilla/5.0")
                                .get();


                        Elements categories2 = document2.select("[data-component='category-tab']");
                        for (Element category2 : categories2) {
                            String name2 = category2.select("p").text();
                            String link2 = category2.attr("abs:href");


                            if (name2.equals("Mobil telefonlar")) {
                                System.out.println("Категория " + name2);
                                System.out.println("Линк " + link2);

                                Document document3 = Jsoup.connect(link2)
                                        .userAgent("Mozilla/5.0")
                                        .get();


                                Elements categories3 = document3.select("[data-component='category-tab']");
                                for (Element category3 : categories3) {
                                    String name3 = category3.select("p").text();
                                    String link3 = category3.attr("abs:href");

                                    if (name3.equals("Apple iPhone")) {
                                        System.out.println("Марка телефона " + name3);
                                        System.out.println("Линк " + link3);

                                        Document document4 = Jsoup.connect(link3)
                                                .userAgent("Mozilla/5.0")
                                                .get();


                                        Elements categories4 = document4.select("[data-component='category-tab']");
                                        for (Element category4 : categories4) {
                                            String name4 = category4.select("p").text();
                                            String link4 = category4.attr("abs:href");

                                            if (name4.equals("iPhone 18 Pro")) {


                                                Document document5 = Jsoup.connect(link4)
                                                        .userAgent("Mozilla/5.0")
                                                        .get();


                                                Elements ads = document5.select("[class*='LFAdTileHorizontal_adTileHorizontalContentContainer']");
                                                System.out.println("Количество " + ads.size());

                                                for (Element ad : ads) {
                                                    String name5 = ad.select("a p").text();
                                                    String link5 = ad.select("a").attr("abs:href");
                                                    System.out.println("Название товара " + name5);
                                                    System.out.println("Линк " + link5);

                                                    Document document6 = Jsoup.connect(link5)
                                                            .userAgent("Mozilla/5.0")
                                                            .get();

                                                    String price = document6.select("p[data-component='lf-heading']").text();
                                                    System.out.println("Цена " + price);

                                                    String city = document6.select("div.AdDetailMap_adDetailCityWrap__7LBol p").text();
                                                    System.out.println("Город " + city);

                                                    String model = document6.select("li:has(p:contains(Model:)) a").text();
                                                    System.out.println("Модель " + model);

                                                    String condition = document6.select("li:has(p:contains(Vəziyyəti:)) a").text();
                                                    System.out.println("Состояние " + condition);

                                                    String optional = document6.select("li:has(p:contains(Əlavə olaraq:)) a").text();
                                                    System.out.println("Дополнительно " + optional);

                                                    String memory = document6.select("li:has(p:contains(Yaddaş tutumu:)) a").text();
                                                    System.out.println("Память " + memory);

                                                }
                                            }

                                        }
                                    }

                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
