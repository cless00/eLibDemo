package com.elib.demo;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;

public class GoldenMaster {

    private static final String GOLDENMASTER_GOLDENMASTER_TXT = "goldenmaster.txt";
    private CmdUI ui;

    String simulatedInput = "printUser 0\r\n"
            + "printDoc 1\r\n"
            + "printLoans\r\n"
//				+ "isHolding 0, 1\r\n"
            + "searchUser Paula\r\n"
            + "searchDoc Refactoring\r\n"
            + "returnDoc 0\r\n"
            + "borrowDoc 0, 2\r\n"
            + "rmDoc 3\r\n"
            + "rmUser 3\r\n"
            + "addUser Kershaw, LA, 010-2220-2345\r\n"
            + "addStaff Furguson, London, 010-3456-1111, A777\r\n"
            + "addBook CQRS, Young, ISBN8938\r\n"
            + "addReport Event Storming, Brandolini, TX0287, Consulting\r\n"
            + "addJournal Software Architectures\r\n"
            + "exit\r\n"; // Bye

    public void generateGoldenMaster() throws IOException {
        Files.write(Paths.get(GOLDENMASTER_GOLDENMASTER_TXT), runResult().getBytes());
    }

    public String readGoldenMaster() throws IOException {
        return Files.readAllLines(Paths.get(GOLDENMASTER_GOLDENMASTER_TXT)).stream().collect(Collectors.joining("\r\n"));
    }

    public String runResult() {
        ByteArrayOutputStream out = getConsoleOutput();
        System.setOut(new PrintStream(out));
        injectScreenInput();

        ui = new CmdUI();
        ui.start();

        return out.toString();
    }

    private void injectScreenInput() {
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));
    }

    private ByteArrayOutputStream getConsoleOutput() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        return out;
    }
}
