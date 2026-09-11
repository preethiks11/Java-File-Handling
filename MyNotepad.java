import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;
import java.io.*;
class MyNotepad extends JFrame
{
JMenuBar mb1;
JMenu m1,m2,m3;
JTextArea t1;
JMenuItem i1,i2,i3,i4,i5,i6,i7,i8,i9,i10;
JFileChooser jf;
String fname;
MyNotepad()
{
fname = null;
setVisible(true);
setSize(500,500);
setTitle(" My Note");
setDefaultCloseOperation(EXIT_ON_CLOSE);
setDefaultLookAndFeelDecorated(true);
t1=new JTextArea(50,50);
jf = new JFileChooser();
mb1=new JMenuBar();
m1=new JMenu("FILE");
m2=new JMenu("EDIT");
m3=new JMenu("CLOSE");

mb1.add(m1);
mb1.add(m2);
mb1.add(m3);

i1=new JMenuItem("New");
i2=new JMenuItem("Open");
i3=new JMenuItem("Save");
i4=new JMenuItem("SaveAs");
i5=new JMenuItem("Close");
i6=new JMenuItem("Cut");
i7=new JMenuItem("Copy");
i8=new JMenuItem("Paste");
i9=new JMenuItem("Select All");
i10=new JMenuItem("Exit");


m1.add(i1); m1.add(i2); m1.add(i3); m1.add(i4); m1.add(i5);
m2.add(i6);m2.add(i7); m2.add(i8); m2.add(i9);
m3.add(i10);

add(t1,BorderLayout.CENTER);
t1.setBounds(50,50,350,350);
setJMenuBar(mb1);

i1.addActionListener(k->
{

t1.setText("");
});
i2.addActionListener(k -> {
jf.showOpenDialog(this);
try{
fname = jf.getSelectedFile().toString();
FileInputStream fis = new FileInputStream(fname);
BufferedReader br = new BufferedReader(new InputStreamReader(fis));
String s = null;
do
{
s = br.readLine();
if(s != null)
t1.append(s+"\n"); 
}while(s != null);
}catch(Exception e){}
});
i3.addActionListener(k -> {
if(fname != null)
{
try{

FileOutputStream fos = new FileOutputStream(fname);

fos.write(t1.getText().getBytes());
}catch(Exception e){}
}
else
call();
});
i4.addActionListener(k -> call());
i5.addActionListener(k->System.exit(1));
i6.addActionListener(k->t1.cut());
i7.addActionListener(k->t1.copy());
i8.addActionListener(k->t1.paste());
i9.addActionListener(k->t1.selectAll());
i10.addActionListener(k->System.exit(1));
}
void call()
{
jf.showSaveDialog(this);
try{
fname = jf.getSelectedFile().toString();
FileOutputStream fos = new FileOutputStream(fname);

fos.write(t1.getText().getBytes());
}catch(Exception e){}

}
public static void main(String arg[])
{
new MyNotepad();
}
}
