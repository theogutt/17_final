package View;

import gui_fields.*;
import gui_main.GUI;

import java.awt.*;
import java.io.IOException;

public class GUI_Handler {
    private GUI gui;
    private MessageHandler message;
    private static GUI_Field[] fields;

    public GUI_Handler() throws IOException {
        message = new MessageHandler();
        fields = new GUI_Field[40];
        setSpecificFields();
        gui = new GUI(fields);
    }

    public void startGameGui(){
        gui.showMessage(message.startGame1());
        gui.showMessage(message.startGame2());
        gui.showMessage(message.startGame3());
        gui.showMessage(message.startGame4());
    }

    public void setSpecificFields(){
        //ejendomsfelter
        GUI_Street rødovrevej= new GUI_Street(); fields[1] = rødovrevej; rødovrevej.setTitle("Rødovrevej");rødovrevej.setSubText("kr. 1.200");rødovrevej.setBorder(Color.BLACK);rødovrevej.setBackGroundColor(Color.cyan);
        GUI_Street hvidovrevej= new GUI_Street(); fields[3] = hvidovrevej; hvidovrevej.setTitle("Hvidovrevej");hvidovrevej.setSubText("kr. 1.200");hvidovrevej.setBorder(Color.BLACK);hvidovrevej.setBackGroundColor(Color.cyan);
        GUI_Street roskildevej= new GUI_Street(); fields[6] = roskildevej; roskildevej.setTitle("Roskildevej");roskildevej.setSubText("kr. 2.000");roskildevej.setBorder(Color.BLACK);roskildevej.setBackGroundColor(Color.pink);
        GUI_Street valby_Langgade= new GUI_Street(); fields[8] = valby_Langgade; valby_Langgade.setTitle("Valby Langgade");valby_Langgade.setSubText("kr. 2.000");valby_Langgade.setBorder(Color.BLACK);valby_Langgade.setBackGroundColor(Color.pink);
        GUI_Street allégade= new GUI_Street(); fields[9] = allégade; allégade.setTitle("Allégade");allégade.setSubText("kr. 2.400");allégade.setBorder(Color.BLACK);allégade.setBackGroundColor(Color.pink);
        GUI_Street frederiksberg_Allé= new GUI_Street(); fields[11] = frederiksberg_Allé; frederiksberg_Allé.setTitle("Frederiksberg Allé");frederiksberg_Allé.setSubText("kr. 2.800");frederiksberg_Allé.setBorder(Color.BLACK);frederiksberg_Allé.setBackGroundColor(new Color(173,255,47));
        GUI_Street bülowsvej= new GUI_Street(); fields[13] = bülowsvej; bülowsvej.setTitle("Bülowsvej");bülowsvej.setSubText("kr. 2.800");bülowsvej.setBorder(Color.BLACK);bülowsvej.setBackGroundColor(new Color(173,255,47));
        GUI_Street gl_Kongevej= new GUI_Street(); fields[14] = gl_Kongevej; gl_Kongevej.setTitle("Gl. Kongevej");gl_Kongevej.setSubText("kr. 3.200");gl_Kongevej.setBorder(Color.BLACK);gl_Kongevej.setBackGroundColor(new Color(173,255,47));
        GUI_Street bernstorffsvej= new GUI_Street(); fields[16] = bernstorffsvej; bernstorffsvej.setTitle("Bernstorffsvej");bernstorffsvej.setSubText("kr. 3.600");bernstorffsvej.setBorder(Color.BLACK);bernstorffsvej.setBackGroundColor(Color.gray);
        GUI_Street hellerupvej= new GUI_Street(); fields[18] = hellerupvej; hellerupvej.setTitle("Hellerupvej");hellerupvej.setSubText("kr. 3.600");hellerupvej.setBorder(Color.BLACK);hellerupvej.setBackGroundColor(Color.gray);
        GUI_Street strandvej= new GUI_Street(); fields[19] = strandvej; strandvej.setTitle("Strandvej");strandvej.setSubText("kr. 4.000");strandvej.setBorder(Color.BLACK);strandvej.setBackGroundColor(Color.gray);
        GUI_Street trianglen= new GUI_Street(); fields[21] = trianglen; trianglen.setTitle("Trianglen");trianglen.setSubText("kr. 4.400");trianglen.setBorder(Color.BLACK);trianglen.setBackGroundColor(Color.red);
        GUI_Street østerbrogade= new GUI_Street(); fields[23] = østerbrogade; østerbrogade.setTitle("Østerbrogade");østerbrogade.setSubText("kr. 4.400");østerbrogade.setBorder(Color.BLACK);østerbrogade.setBackGroundColor(Color.red);
        GUI_Street grønningen= new GUI_Street(); fields[24] = grønningen; grønningen.setTitle("Grønningen");grønningen.setSubText("kr. 4.800");grønningen.setBorder(Color.BLACK);grønningen.setBackGroundColor(Color.red);
        GUI_Street bredgade= new GUI_Street(); fields[26] = bredgade; bredgade.setTitle("Bredgade");bredgade.setSubText("kr. 5.200");bredgade.setBorder(Color.BLACK);bredgade.setBackGroundColor(Color.white);
        GUI_Street kgs_nytorv= new GUI_Street(); fields[27] = kgs_nytorv; kgs_nytorv.setTitle("Kgs. nytorv");kgs_nytorv.setSubText("kr. 5.200");kgs_nytorv.setBorder(Color.BLACK);kgs_nytorv.setBackGroundColor(Color.white);
        GUI_Street østergade= new GUI_Street(); fields[29] = østergade; østergade.setTitle("Østergade");østergade.setSubText("kr. 5.600");østergade.setBorder(Color.BLACK);østergade.setBackGroundColor(Color.white);
        GUI_Street amagertorv= new GUI_Street(); fields[31] = amagertorv; amagertorv.setTitle("Amagertorv");amagertorv.setSubText("kr. 6.000");amagertorv.setBorder(Color.BLACK);amagertorv.setBackGroundColor(Color.yellow);
        GUI_Street vimmelskaftet= new GUI_Street(); fields[32] = vimmelskaftet; vimmelskaftet.setTitle("Vimmelskaftet");vimmelskaftet.setSubText("kr. 6.000");vimmelskaftet.setBorder(Color.BLACK);vimmelskaftet.setBackGroundColor(Color.yellow);
        GUI_Street nygade= new GUI_Street(); fields[34] = nygade; nygade.setTitle("Nygade");nygade.setSubText("kr. 6.400");nygade.setBorder(Color.BLACK);nygade.setBackGroundColor(Color.yellow);
        GUI_Street frederiksberggade= new GUI_Street(); fields[37] = frederiksberggade; frederiksberggade.setTitle("Frederiksberggade");frederiksberggade.setSubText("kr. 7.000");frederiksberggade.setBorder(Color.BLACK);frederiksberggade.setBackGroundColor(new Color(139,0,139));
        GUI_Street rådhuspladsen= new GUI_Street(); fields[39] = rådhuspladsen; rådhuspladsen.setTitle("Rådhuspladsen");rådhuspladsen.setSubText("kr. 8.000");rådhuspladsen.setBorder(Color.BLACK);rådhuspladsen.setBackGroundColor(new Color(139,0,139));
        //prøv lykken felter
        GUI_Chance felt3 = new GUI_Chance(); fields[2] = felt3;
        GUI_Chance felt8 = new GUI_Chance(); fields[7] = felt8;
        GUI_Chance felt18 = new GUI_Chance(); fields[17] = felt18;
        GUI_Chance felt23 = new GUI_Chance(); fields[22] = felt23;
        GUI_Chance felt34 = new GUI_Chance(); fields[33] = felt34;
        GUI_Chance felt37 = new GUI_Chance(); fields[36] = felt37;
        //færge felter
        GUI_Shipping lBfærgerne = new GUI_Shipping(); fields[5] = lBfærgerne; lBfærgerne.setTitle("LB færgerne"); lBfærgerne.setSubText("4.000");
        GUI_Shipping danmark= new GUI_Shipping(); fields[15] = danmark; danmark.setTitle("Danmark"); danmark.setSubText("4.000");
        GUI_Shipping mols_linien= new GUI_Shipping(); fields[25] = mols_linien; mols_linien.setTitle("Mols-linien"); mols_linien.setSubText("4.000");
        GUI_Shipping skandinavisk= new GUI_Shipping(); fields[35] = skandinavisk; skandinavisk.setTitle("Skandinavisk"); skandinavisk.setSubText("4.000");
        //fængsel felt
        GUI_Jail fængsel = new GUI_Jail(); fields[10] = fængsel; fængsel.setSubText("I Fængsel");
        GUI_Jail defængsles = new GUI_Jail(); fields[30] = defængsles; defængsles.setSubText("De Fængsles");
        //bryggeri felter
        GUI_Brewery carlsberg = new GUI_Brewery(); fields[12] = carlsberg; carlsberg.setTitle("Carlsberg"); carlsberg.setSubText("3.000");
        GUI_Field coca_Cola = new GUI_Street(); fields[28] = coca_Cola; coca_Cola.setTitle("Coca Cola"); coca_Cola.setSubText("3.000"); coca_Cola.setBackGroundColor(Color.red);
        //start felt
        GUI_Start start = new GUI_Start(); fields[0] = start; start.setBackGroundColor(Color.red); start.setSubText("modtag 4.000"); start.setTitle("START");
        //skatte felter
        GUI_Tax indkomstskat = new GUI_Tax(); fields[4] = indkomstskat; indkomstskat.setSubText("10% el. 4.000"); indkomstskat.setTitle("Indkomstskat"); indkomstskat.setBackGroundColor(Color.white );
        GUI_Tax statsskat = new GUI_Tax(); fields[38] = statsskat; statsskat.setSubText("betal 2.000"); statsskat.setTitle("Statsskat"); statsskat.setBackGroundColor(Color.white );
        //parkering felt
        GUI_Refuge parkering = new GUI_Refuge(); fields[20] = parkering; parkering.setSubText("Parkering");
    }
}