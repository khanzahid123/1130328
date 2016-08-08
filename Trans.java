import java.io.*;
import java.util.*;


public class Trans
{

	public static void main(String[] args) throws IOException
	{    Scanner sc=new Scanner(System.in);
		int length,i,j,div,mod,m=0,k,ch;
		String Encrypt="";
		System.out.println("Enter your choice\n1.Encrypt\n2.Decrypt\n3.Exit\n");
		ch=sc.nextInt();
		switch(ch)
		{
		case 1: 
		System.out.println("Input Data to encypt:"); 
		File file=new File("D:\\1130328\\input.txt");
	
		FileReader ins=new FileReader(file);
		
		BufferedReader br=new BufferedReader(ins);
		String str = br.readLine();
		length=str.length();
		int key;
		System.out.println("input key value");
		key=sc.nextInt();
		if(length<=key)
		{
			System.out.println("Please Enter Key Less than the file length");
			}
		else
		{
		char a[]=new char[length];
		a=str.toCharArray();
		div=length/key;
		//mod=length%key;
//System.out.println(length);
	
	j=div+1;
//System.out.println(j);
		char temp[][]=new char[j][key];

	
		for(i=0;i<j;i++)
		{
			for(k=0;k<key;k++)
			{
				
				if(m<length)
				{
				temp[i][k]=a[m];
				m++;
				System.out.print("\t"+temp[i][k]);

				}
			}
			System.out.println();
			}
             char temp1[][]=new char[key][j];

		for(i=0;i<j;i++)
		{
			for(k=0;k<key;k++)
			{
				temp1[k][i]=temp[i][k];
			}
			
			}
			System.out.println("Ecripted message is");
			
	
		for(i=0;i<key;i++)
		{
			for(k=0;k<j;k++)
			{
			System.out.print("\t"+temp[k][i]);	
			Encrypt=Encrypt + temp[k][i];
			}
			System.out.println();
			}


		
		}
			File file1=new File("D:\\1130328\\output.txt");
			FileWriter fw=new FileWriter(file1.getAbsoluteFile());
			BufferedWriter bw=new BufferedWriter(fw);
			bw.write(Encrypt);
			bw.close();
			System.out.println(Encrypt);
			break;
	case 2: 
	int m1=0;
		System.out.println("input key value");
		key=sc.nextInt();
		File file2=new File("D:\\1130328\\output.txt");
			FileReader fw1=new FileReader(file2);
			BufferedReader bw1=new BufferedReader(fw1);
			String str1 = bw1.readLine();
		int length1=str1.length();
		char a1[]=new char[length1];
		a1=str1.toCharArray();
	div=length1/key;
	j=div+1;
//System.out.println(j);
		char temp[][]=new char[j][key];

	
		for(i=0;i<key;i++)
		{
			for(k=0;k<j;k++)
			{
				
				
				if(m<length1)
				{
				temp[i][k]=a1[m1];
				m1++;
				System.out.print("\t"+temp[i][k]);

				}
				
			}
			System.out.println();
			}
      char temp1[][]=new char[key][j];

		for(i=0;i<key;i++)
		{
			for(k=0;k<j;k++)
			{
				temp1[k][i]=temp[i][k];
			}
			
			}
			System.out.println("Ecripted message is");
			
	
		for(i=0;i<j;i++)
		{
			for(k=0;k<key;k++)
			{
			System.out.print("\t"+temp[k][i]);	
			Encrypt=Encrypt + temp[k][i];
			}
			System.out.println();
			}


	
	break;
    case 3: break;
	default : System.out.println();
	}
	}

	
}
