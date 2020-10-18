package edu.soen341.projectAS3.options;

import static java.lang.System.exit;

class BannerOption extends Option {
    public BannerOption() {
        super(new String[]{"-b"},"-banner");
        setEnable(true);
    }

    @Override
    public void process() {
        switch (getClassName()){
            case "CopyCounter":
                System.out.println("wcOO copy Version 2.0\n" +
                        "Copyright (C) Concordia University 2020. All Rights Reserved.\n" +
                        "Written by TEAM C3\n");
                break;
            case "CharCounter":
                System.out.println("wcOO charcount Version 2.0\n" +
                        "Copyright (C) Concordia University 2020. All Rights Reserved.\n" +
                        "Written by TEAM C3\n");
                break;
            case "WordCounter":
                System.out.println("wcOO wordcount Version 2.0\n" +
                        "Copyright (C) Concordia University 2020. All Rights Reserved.\n" +
                        "Written by TEAM C3\n");
                break;
            case "LineCounter":
                System.out.println("wcOO linecount Version 2.0\n" +
                        "Copyright (C) Concordia University 2020. All Rights Reserved.\n" +
                        "Written by TEAM C3\n");
                break;
            default:
                System.out.println("wcOO Version 2.0\n" +
                        "Copyright (C) Concordia University 2020. All Rights Reserved.\n" +
                        "Written by TEAM C3\n");
                break;
        }
        exit(1);
    }

}
