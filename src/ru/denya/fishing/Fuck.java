package ru.denya.fishing;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.Scanner;

public class Fuck {
    public static void main(String[] args) {

        /*for (int i = 0; i < protocolLibrary().size(); i++) {
            for (int j = 0; j < nameLibrary.size(); j++) {
                for (int k = 0; k < domenLibrary().size(); k++) {
                    for (int l = 0; l < podDomenLibrary.size(); l++) {

                    }

                    int finalI = i;
                    int finalJ = j;
                    int finalK = k;

                    try {
                        Thread.sleep(frequency);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    int finalStep = (int) step;
                    ArrayList<String> finalMainTitle = mainTitle;
                    Thread th = new Thread(new Runnable() {
                        @Override
                        public void run() {
                            Inetwork inetwork = new Inetwork();
                            inetwork.loadPage(protocolLibrary().get(finalI) + "://" + nameLibrary.get(finalJ) + "." + domenLibrary().get(finalK));

                            if (!inetwork.getResponceCode().equalsIgnoreCase("404")) {
                                suspectFile(protocolLibrary().get(finalI) + "://" + nameLibrary.get(finalJ) + "." + domenLibrary().get(finalK) + " - " + inetwork.getResponceCode() + " (" + inetwork.getTitle() + ")", sDate);
                                if (inetwork.getTitle().equalsIgnoreCase(title)) {
                                    discoverFile(protocolLibrary().get(finalI) + "://" + nameLibrary.get(finalJ) + "." + domenLibrary().get(finalK) + " - " + inetwork.getResponceCode() + " (" + inetwork.getTitle() + ")", sDate);
                                }

                                ArrayList<String> inetTitle = new ArrayList<>();
                                inetTitle = replaceTitles(inetwork.getTitle());

                                for (int l = 0; l < finalMainTitle.size(); l++) {
                                    for (int m = 0; m < inetTitle.size(); m++) {
                                        if (finalMainTitle.get(l).equalsIgnoreCase(inetTitle.get(m))) {
                                            discoverFile(protocolLibrary().get(finalI) + "://" + nameLibrary.get(finalJ) + "." + domenLibrary().get(finalK) + " - " + inetwork.getResponceCode() + " (" + inetwork.getTitle() + ")", sDate);
                                        }
                                    }
                                }
                            }
                            writeLog(finalStep + ": " + protocolLibrary().get(finalI) + "://" + nameLibrary.get(finalJ) + "." + domenLibrary().get(finalK) + " - " + inetwork.getResponceCode() + " (" + inetwork.getTitle() + ")", sDate);
                        }
                    });
                    th.start();

                    step++;
                    double percent = (step / all);
                    percent = percent * 100;

                    if ((int) (percent) > temp) {
                        temp = (int) percent;
                        if (temp != 100) {
                            System.out.println(temp + "%");
                            writeProgress(String.valueOf(temp) + "%", sDate);
                        }

                    }

                }
            }
        }*/


    }

}
