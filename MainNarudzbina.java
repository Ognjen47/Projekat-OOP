import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.*;

public class MainNarudzbina extends JFrame implements ActionListener {
    private final int sirina = 450;
    private final int visina = 550;
    private JLabel label1,label2,label3;
    private JButton button1,button2,button3;
    private JRadioButton radioButton1,radioButton2,radioButton3;
    private JTextArea textArea;
    private JTextField textField;
    private ArrayList<String> porucenaJela;
    private JComboBox comboBox;
    private ButtonGroup grupa;
    private int indeksPadajuceListe;
    private String [] proizvodi = new String[6];
    private double ukupnaCena;

    public MainNarudzbina(){
        setBounds(500,40,sirina,visina);
        setTitle("Online narudzbina hrane");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        label1= new JLabel("Odabir hrane:");
        label1.setBounds(10,10,100,25);
        for(Narudzbina hrana:Narudzbina.values()){
            proizvodi[hrana.ordinal()]=hrana.name();
        }
        comboBox=new JComboBox<>(proizvodi);
        comboBox.setBounds(10,40,200,25);
        comboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                indeksPadajuceListe=comboBox.getSelectedIndex();
                Narudzbina narudzbina=Narudzbina.valueOf(proizvodi[indeksPadajuceListe]);
            }
        });

        radioButton1=new JRadioButton("Mala porcija");
        radioButton1.setBounds(10,85,100,25);
        radioButton1.addActionListener(this);

        radioButton2=new JRadioButton("Srednja porcija");
        radioButton2.setBounds(110,85,120,25);
        radioButton2.setSelected(true);
        radioButton2.addActionListener(this);

        radioButton3=new JRadioButton("Velika porcija");
        radioButton3.setBounds(230,85,110,25);
        radioButton3.addActionListener(this);

        grupa=new ButtonGroup();
        grupa.add(radioButton1);
        grupa.add(radioButton2);
        grupa.add(radioButton3);
        button1=new JButton("Dodaj");
        button1.setBounds(230,40,80,30);
        button1.addActionListener(this);

        button2=new JButton("Ukloni");
        button2.setBounds(315,40,80,30);
        button2.addActionListener(this);


        label2=new JLabel("Narucena hrana:");
        label2.setBounds(10,115,100,25);
        textArea=new JTextArea();
        textArea.setBounds(10,140,300,200);

        textField=new JTextField();
        textField.setBounds(10,370,100,25);
        textField.setEditable(false);

        label3=new JLabel("Ukupna cena:");
        label3.setBounds(10, 350, 100, 25);

        button3=new JButton("Izracunaj ukupnu cenu");
        button3.setBounds(10,400,180,35);
        button3.addActionListener(this);

        add(label1); add(comboBox); add(radioButton1); add(radioButton2); add(radioButton3);
        add(button1); add(button2); add(textArea); add(label2); add(textField); add(button3);
        add(label3);
        setVisible(true);
    }
    public static void main(String[] args) {
        new MainNarudzbina();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==button1){
            Narudzbina narudzbina=Narudzbina.valueOf(proizvodi[indeksPadajuceListe]);
            double cenaSrednje = narudzbina.getCena();
            double cenaMale=cenaSrednje*0.90;
            double cenaVelike=cenaSrednje*1.10;

            if (radioButton1.isSelected()){
                textArea.append(narudzbina.getIme() + ", " + radioButton1.getText() + ':' +Math.round(cenaMale)+" din."+'\n');
                ukupnaCena+=cenaMale;}
            if (radioButton2.isSelected()){
                textArea.append(narudzbina.getIme() + ", " + radioButton2.getText() + ':' +Math.round(cenaSrednje)+" din."+'\n');
                ukupnaCena+=cenaSrednje;}
            if (radioButton3.isSelected()){
                textArea.append(narudzbina.getIme() + ", " + radioButton3.getText() + ':' +Math.round(cenaVelike)+" din."+'\n');
                ukupnaCena+=cenaVelike;}
        }
        if(e.getSource()==button2){
            textArea.setText("");
            ukupnaCena=0;

        }
        if(e.getSource()==button3){
            textField.setText(String.valueOf(ukupnaCena)+ " din.");
        }

    }
}

