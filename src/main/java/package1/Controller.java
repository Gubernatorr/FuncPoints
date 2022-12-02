package package1;

import java.net.URL;
import java.util.*;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button Calculate;
/////////////////////////////////////////
    @FXML
    private TextField NumForCalcul1;

    @FXML
    private TextField NumForCalcul2;

    @FXML
    private TextField NumForCalcul3;

    @FXML
    private TextField NumForCalcul4;

    @FXML
    private TextField NumForCalcul5;
/////////////////////////////////////////////
    @FXML
    private ChoiceBox<String> choiceBox1;

    @FXML
    private ChoiceBox<String> choiceBox2;

    @FXML
    private ChoiceBox<String> choiceBox3;

    @FXML
    private ChoiceBox<String> choiceBox4;

    @FXML
    private ChoiceBox<String> choiceBox5;
////////////////////////////////////////////////////////////
    @FXML
    private ChoiceBox<String> choiceBox_1;

    @FXML
    private ChoiceBox<String> choiceBox_2;

    @FXML
    private ChoiceBox<String> choiceBox_3;

    @FXML
    private ChoiceBox<String> choiceBox_4;

    @FXML
    private ChoiceBox<String> choiceBox_5;

    @FXML
    private ChoiceBox<String> choiceBox_6;

    @FXML
    private ChoiceBox<String> choiceBox_7;

    @FXML
    private ChoiceBox<String> choiceBox_8;

    @FXML
    private ChoiceBox<String> choiceBox_9;

    @FXML
    private ChoiceBox<String> choiceBox_10;

    @FXML
    private ChoiceBox<String> choiceBox_11;

    @FXML
    private ChoiceBox<String> choiceBox_12;

    @FXML
    private ChoiceBox<String> choiceBox_13;

    @FXML
    private ChoiceBox<String> choiceBox_14;

    @FXML
    private ChoiceBox<String> langChoiceBox;

    /////////////////////////////////////////////////////
    @FXML
    private Text txtVAF;

    @FXML
    private Text txtAFPC;

    @FXML
    private Text txtSLOC;

    @FXML
    private Text txtFP;
////////////////////////////////////////////
    @FXML
    void calculateButtonPressed(ActionEvent event) {
        List<ChoiceBox<String>> boxes1 = new ArrayList<>(Arrays.asList(choiceBox1, choiceBox2, choiceBox3, choiceBox4, choiceBox5));
        List<ChoiceBox<String>> boxes2 = new ArrayList<>(Arrays.asList(choiceBox_1, choiceBox_2, choiceBox_3, choiceBox_4, choiceBox_5, choiceBox_6,
                choiceBox_7, choiceBox_8, choiceBox_9, choiceBox_10, choiceBox_11, choiceBox_12, choiceBox_13, choiceBox_14));

        int TDI = sumTDI(boxes2);
        int UFPC = calculUFPC();
        int LM = calculLM();
        double VAF = 0.65 + 0.01 * TDI;
        double AFPC = VAF * UFPC;
        double SLOC = AFPC * LM;
        txtVAF.setText(String.valueOf(VAF));
        txtAFPC.setText(String.valueOf(AFPC));
        txtSLOC.setText(String.valueOf(SLOC));
        txtFP.setText(String.valueOf(UFPC));

    }

    int[] choiceBoxValues1 = {7,10,15};
    int[] choiceBoxValues2 = {5,7,10};
    int[] choiceBoxValues3 = {3,4,6};
    int[] choiceBoxValues4 = {4,5,7};
    int[] choiceBoxValues5 = {3,4,9};
    int[][] allValues = {choiceBoxValues1, choiceBoxValues2, choiceBoxValues3, choiceBoxValues4, choiceBoxValues5};

    int[] getChoiceBoxStaticValues = {0,1,2,3,4,5};

    public int sumTDI(List<ChoiceBox<String>> list){
        int sum = 0;

        for (ChoiceBox<String> temp : list){
            sum += Integer.parseInt(temp.getValue());
        }
        System.out.println(sum);
        return sum;
    }
    public int calculUFPC(){
        List<ChoiceBox<String>> boxes = new ArrayList<>(Arrays.asList(choiceBox1, choiceBox2, choiceBox3, choiceBox4, choiceBox5));
        List<TextField> nums = new ArrayList<>(Arrays.asList(NumForCalcul1, NumForCalcul2, NumForCalcul3, NumForCalcul4, NumForCalcul5));
        int[][] allValues = {choiceBoxValues1, choiceBoxValues2, choiceBoxValues3, choiceBoxValues4, choiceBoxValues5};
        String[][] valuess = {{"Low: 7", "Average: 10", "High: 15"}, {"Low: 5", "Average: 7", "High: 10"}, {"Low: 3", "Average: 4", "High: 6"}, {"Low: 4", "Average: 5", "High: 7"},
                {"Low: 3", "Average: 4", "High: 9"}};

        int UFPC = 0;
        for(int j = 0; j < 5; j++){
            if(boxes.get(j).getValue().equals(valuess[j][0])){
                UFPC += Integer.parseInt(nums.get(j).getText()) * allValues[j][0];
            } else if(boxes.get(j).getValue().equals(valuess[j][1])){
                UFPC += Integer.parseInt(nums.get(j).getText()) * allValues[j][1];
            } else if(boxes.get(j).getValue().equals(valuess[j][2])){
                UFPC += Integer.parseInt(nums.get(j).getText()) * allValues[j][2];
            }
        }
        return UFPC;
    }

    public int calculLM(){
        int LM = 0;
        Integer[] langArray = {Basic_Assembler = 320, Autocoder = 320,  Netron_CAP = 296,  Macro_Assembler = 213,  C =  128, Batch_files_DOS  = 128,  Basic = 107, Lotus_macros =  107,
                ALGOL = 105,  COBOL = 105, FORTRAN = 105,  JOVIAL = 105,  Mixed_programming_languages = 105,   JCL = 96,  VPF = 95, Pascal = 91, COBOL_ANSI_85 = 91,
                APS = 86, Slogan = 81, RPG = 80, Modula_2 = 80, PL_1 = 80,     Parallel_Pascal = 80,   Fortran_95 = 71, Mantis = 71,  Sabretalk = 70,   Mapper = 69,
                ColdFusion = 68,                          Datastage = 67,                                 Ideal = 66,
                Basic_ANSI = 64,                        FORTH = 64,                                    LISP = 64,
                PROLOG = 64,                              Powerhouse = 63,                                Uniface = 61,
                NET = 60,                                JSP = 59,                                       LOGO = 58,
                C_Charp = 58,                                  J2EE = 57,                                      Expanded_LISP = 56,
                RPG_III = 56,                             ASP = 56,                                       Java = 55,
                JavaScript = 54,                          C_pl = 53,                                       YACC = 53,
                Culprit = 51,                             Natural = 51,                                   KML = 50, Visual_Basic = 50,                        REXX = 50,                                      Ada_95 = 49,
                PL_SQL = 47,                              CICS = 46,                                      SIMULA = 46,
                Taskmate = 45,                            Focus = 45,                                     Web_Scripts = 44,
                Pacbase = 42,                             Database_languages = 40,                        Clipper_DB_і_dBase_III = 40,
                Informix = 40,                            Oracle_і_SYBASE = 40,                           Openroad = 39,
                Access = 38,                              VBSript = 38,                                   Advantage = 38,  PeopleSoft = 37,                          Cool_Gen_IEF = 37,                              DBase_IV = 36,
                Adoption_support_languages = 35,          FoxPro_25 = 34,                                APL = 32,
                Static_languages_SAS = 32,              Maestro = 30,                                   DELPHI = 29,
                Standard_object_oriented_languages = 29,  Powerbuilder = 28,                              VB_Net = 28,
                OBJECTIVE_C = 27,                         Lotus_Script = 23,                              Oracle_Developer_2000 = 23,
                Smalltalk = 21,                           awk = 21,                                       EIFFEL = 21, Shell_scripts_Perl = 21,                Standard_languages_of_the_4th_generation  = 20,  OR3_4GL = 20,
                Application_Builder = 20,                 CORBA = 20,                                     Cristal_Reports = 20,
                Datatrieve = 20,                          CLIPPER = 19,                                   ABAP_SAP = 18, HTML_30 = 15,                            Siebel_Tools = 13,                              SQL = 13,
                Easytrieve_plus = 13,                         SQL_Forms = 11,                                 Excel = 6, QUATTRO_PRO = 6,                          Icon_creation_languages = 4};

        String[] langStrings = {"Basic_Assembler = 320", "Autocoder = 320",  "Netron_CAP = 296",  "Macro_Assembler = 213",  "C =  128", "Batch_files_DOS  = 128",  "Basic = 107",
                "Lotus_macros =  107", "ALGOL = 105",  "COBOL = 105", "FORTRAN = 105",  "JOVIAL = 105",  "Mixed_programming_languages = 105",   "JCL = 96",  "VPF = 95", "Pascal = 91", "COBOL_ANSI_85 = 91",
                "APS = 86", "Slogan = 81", "RPG = 80", "Modula_2 = 80", "PL_1 = 80", "Parallel_Pascal = 80", "Fortran_95 = 71",
                "Mantis = 71",                              "Sabretalk = 70",                                 "Mapper = 69",
                "ColdFusion = 68",                          "Datastage = 67",                                 "Ideal = 66",
                "Basic_ANSI = 64",                        "FORTH = 64",                                    "LISP = 64",
                "PROLOG = 64",                              "Powerhouse = 63",                                "Uniface = 61",
                "NET = 60",                                "JSP = 59",                                       "LOGO = 58",
                "C_Charp = 58",                                  "J2EE = 57",                                      "Expanded_LISP = 56",
                "RPG_III = 56",                             "ASP = 56",                                       "Java = 55",
                "JavaScript = 54",                          "C_pl = 53",                                       "YACC = 53",
                "Culprit = 51",                             "Natural = 51",                                   "KML = 50",
                "Visual_Basic = 50",                        "REXX = 50",                                      "Ada_95 = 49",
                "PL_SQL = 47",                              "CICS = 46",                                      "SIMULA = 46",
                "Taskmate = 45",                            "Focus = 45",                                     "Web_Scripts = 44",
                "Pacbase = 42",                             "Database_languages = 40",                        "Clipper_DB_і_dBase_III = 40",
                "Informix = 40",                            "Oracle_і_SYBASE = 40",                           "Openroad = 39",
                "Access = 38",                              "VBSript = 38",                                   "Advantage = 38",
                "PeopleSoft = 37",                          "Cool_Gen_IEF = 37",                              "DBase_IV = 36",
                "Adoption_support_languages = 35",          "FoxPro_25 = 34",                                "APL = 32",
                "Static_languages_SAS = 32",              "Maestro = 30",                                   "DELPHI = 29",
                "Standard_object_oriented_languages = 29",  "Powerbuilder = 28",                              "VB_Net = 28",
                "OBJECTIVE_C = 27",                         "Lotus_Script = 23",                              "Oracle_Developer_2000 = 23",
                "Smalltalk = 21",                           "awk = 21",                                       "EIFFEL = 21",
                "Shell_scripts_Perl = 21",                "Standard_languages_of_the_4th_generation  = 20",  "OR3_4GL = 20",
                "Application_Builder = 20",                 "CORBA = 20",                                     "Cristal_Reports = 20",
                "Datatrieve = 20",                          "CLIPPER = 19",                                   "ABAP_SAP = 18",
                "HTML_30 = 15",                            "Siebel_Tools = 13",                              "SQL = 13",
                "Easytrieve_plus = 13",                         "SQL_Forms = 11",                                 "Excel = 6",
                "QUATTRO_PRO = 6",                          "Icon_creation_languages = 4"};

        for(int i = 0; i < langStrings.length; i++){
            if(langChoiceBox.getValue().equals(langStrings[i])){
                LM = langArray[i];
            }
        }

        return LM;
    }

    int Basic_Assembler = 320, Autocoder = 320,  Netron_CAP = 296,  Macro_Assembler = 213,  C =  128, Batch_files_DOS  = 128,  Basic = 107,
    Lotus_macros =  107, ALGOL = 105,  COBOL = 105, FORTRAN = 105,  JOVIAL = 105,  Mixed_programming_languages = 105,   JCL = 96,  VPF = 95, Pascal = 91, COBOL_ANSI_85 = 91,
    APS = 86, Slogan = 81, RPG = 80, Modula_2 = 80, PL_1 = 80,                                Parallel_Pascal = 80,                           Fortran_95 = 71,
            Mantis = 71,                              Sabretalk = 70,                                 Mapper = 69,
            ColdFusion = 68,                          Datastage = 67,                                 Ideal = 66,
            Basic_ANSI = 64,                        FORTH = 64,                                    LISP = 64,
            PROLOG = 64,                              Powerhouse = 63,                                Uniface = 61,
            NET = 60,                                JSP = 59,                                       LOGO = 58,
            C_Charp = 58,                                  J2EE = 57,                                      Expanded_LISP = 56,
            RPG_III = 56,                             ASP = 56,                                       Java = 55,
            JavaScript = 54,                          C_pl = 53,                                       YACC = 53,
            Culprit = 51,                             Natural = 51,                                   KML = 50,
            Visual_Basic = 50,                        REXX = 50,                                      Ada_95 = 49,
            PL_SQL = 47,                              CICS = 46,                                      SIMULA = 46,
            Taskmate = 45,                            Focus = 45,                                     Web_Scripts = 44,
            Pacbase = 42,                             Database_languages = 40,                        Clipper_DB_і_dBase_III = 40,
            Informix = 40,                            Oracle_і_SYBASE = 40,                           Openroad = 39,
            Access = 38,                              VBSript = 38,                                   Advantage = 38,
            PeopleSoft = 37,                          Cool_Gen_IEF = 37,                              DBase_IV = 36,
            Adoption_support_languages = 35,          FoxPro_25 = 34,                                APL = 32,
            Static_languages_SAS = 32,              Maestro = 30,                                   DELPHI = 29,
            Standard_object_oriented_languages = 29,  Powerbuilder = 28,                              VB_Net = 28,
            OBJECTIVE_C = 27,                         Lotus_Script = 23,                              Oracle_Developer_2000 = 23,
            Smalltalk = 21,                           awk = 21,                                       EIFFEL = 21,
            Shell_scripts_Perl = 21,                Standard_languages_of_the_4th_generation  = 20,  OR3_4GL = 20,
            Application_Builder = 20,                 CORBA = 20,                                     Cristal_Reports = 20,
            Datatrieve = 20,                          CLIPPER = 19,                                   ABAP_SAP = 18,
            HTML_30 = 15,                            Siebel_Tools = 13,                              SQL = 13,
            Easytrieve_plus = 13,                         SQL_Forms = 11,                                 Excel = 6,
            QUATTRO_PRO = 6,                          Icon_creation_languages = 4;


    @FXML
    void initialize() {

        List<ChoiceBox<String>> boxes1 = new ArrayList<>(Arrays.asList(choiceBox1, choiceBox2, choiceBox3, choiceBox4, choiceBox5));
        String[] choiseBoxStrings1 = {"Low: 7", "Average: 10", "High: 15"}; String[] choiseBoxStrings2 = {"Low: 5", "Average: 7", "High: 10"};
        String[] choiseBoxStrings3 = {"Low: 3", "Average: 4", "High: 6"}; String[] choiseBoxStrings4 = {"Low: 4", "Average: 5", "High: 7"};
        String[] choiseBoxStrings5 = {"Low: 3", "Average: 4", "High: 9"};
        String[][] valuess = {{"Low: 7", "Average: 10", "High: 15"}, {"Low: 5", "Average: 7", "High: 10"}, {"Low: 3", "Average: 4", "High: 6"}, {"Low: 4", "Average: 5", "High: 7"},
                {"Low: 3", "Average: 4", "High: 9"}};

        int i = 0;
        for(ChoiceBox<String> temp : boxes1){
            temp.getItems().addAll(valuess[i]);
            temp.setValue(valuess[i][0]);
            i++;
        }

        List<ChoiceBox<String>> boxes2 = new ArrayList<>(Arrays.asList(choiceBox_1, choiceBox_2, choiceBox_3, choiceBox_4, choiceBox_5, choiceBox_6,
                choiceBox_7, choiceBox_8, choiceBox_9, choiceBox_10, choiceBox_11, choiceBox_12, choiceBox_13, choiceBox_14));
        String[] choiseBoxStrings = {"0", "1", "2", "3",  "4",  "5"};
        for(ChoiceBox<String> temp : boxes2){
            temp.getItems().addAll(choiseBoxStrings);
            temp.setValue("3");
        }
        List<TextField> nums = new ArrayList<>(Arrays.asList(NumForCalcul1, NumForCalcul2, NumForCalcul3, NumForCalcul4, NumForCalcul5));
        for(TextField txt : nums){
            txt.setText("3");
        }

        String[] langStrings = {"Basic_Assembler = 320", "Autocoder = 320",  "Netron_CAP = 296",  "Macro_Assembler = 213",  "C =  128", "Batch_files_DOS  = 128",  "Basic = 107",
                "Lotus_macros =  107", "ALGOL = 105",  "COBOL = 105", "FORTRAN = 105",  "JOVIAL = 105",  "Mixed_programming_languages = 105",   "JCL = 96",  "VPF = 95", "Pascal = 91", "COBOL_ANSI_85 = 91",
                "APS = 86", "Slogan = 81", "RPG = 80", "Modula_2 = 80", "PL_1 = 80", "Parallel_Pascal = 80", "Fortran_95 = 71",
                "Mantis = 71",                              "Sabretalk = 70",                                 "Mapper = 69",
                "ColdFusion = 68",                          "Datastage = 67",                                 "Ideal = 66",
                "Basic_ANSI = 64",                        "FORTH = 64",                                    "LISP = 64",
                "PROLOG = 64",                              "Powerhouse = 63",                                "Uniface = 61",
                "NET = 60",                                "JSP = 59",                                       "LOGO = 58",
                "C_Charp = 58",                                  "J2EE = 57",                                      "Expanded_LISP = 56",
                "RPG_III = 56",                             "ASP = 56",                                       "Java = 55",
                "JavaScript = 54",                          "C_pl = 53",                                       "YACC = 53",
                "Culprit = 51",                             "Natural = 51",                                   "KML = 50",
                "Visual_Basic = 50",                        "REXX = 50",                                      "Ada_95 = 49",
                "PL_SQL = 47",                              "CICS = 46",                                      "SIMULA = 46",
                "Taskmate = 45",                            "Focus = 45",                                     "Web_Scripts = 44",
                "Pacbase = 42",                             "Database_languages = 40",                        "Clipper_DB_і_dBase_III = 40",
                "Informix = 40",                            "Oracle_і_SYBASE = 40",                           "Openroad = 39",
                "Access = 38",                              "VBSript = 38",                                   "Advantage = 38",
                "PeopleSoft = 37",                          "Cool_Gen_IEF = 37",                              "DBase_IV = 36",
                "Adoption_support_languages = 35",          "FoxPro_25 = 34",                                "APL = 32",
                "Static_languages_SAS = 32",              "Maestro = 30",                                   "DELPHI = 29",
                "Standard_object_oriented_languages = 29",  "Powerbuilder = 28",                              "VB_Net = 28",
                "OBJECTIVE_C = 27",                         "Lotus_Script = 23",                              "Oracle_Developer_2000 = 23",
                "Smalltalk = 21",                           "awk = 21",                                       "EIFFEL = 21",
                "Shell_scripts_Perl = 21",                "Standard_languages_of_the_4th_generation  = 20",  "OR3_4GL = 20",
                "Application_Builder = 20",                 "CORBA = 20",                                     "Cristal_Reports = 20",
                "Datatrieve = 20",                          "CLIPPER = 19",                                   "ABAP_SAP = 18",
                "HTML_30 = 15",                            "Siebel_Tools = 13",                              "SQL = 13",
                "Easytrieve_plus = 13",                         "SQL_Forms = 11",                                 "Excel = 6",
                "QUATTRO_PRO = 6",                          "Icon_creation_languages = 4"};

        langChoiceBox.getItems().addAll(langStrings);
        langChoiceBox.setValue("Basic_Assembler = 320");


    }

}
