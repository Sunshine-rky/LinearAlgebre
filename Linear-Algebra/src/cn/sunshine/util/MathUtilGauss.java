package cn.sunshine.util;

public class MathUtilGauss {
	 
	/**
	 * @列主元高斯消去法
	 */
	static double a[][];
	static double b[];
	static double x[];
	static int n;
	static int n2; //记录换行的次数
    public static void Elimination(){  //消元
    	PrintA();
		for(int k=0;k<n;k++)
		{
			Wrap(k);
			for(int i=k+1;i<n;i++)
			{
				double l=a[i][k]/a[k][k];
				a[i][k]=0.0;
				for(int j=k+1;j<n;j++)
					a[i][j]=a[i][j]-l*a[k][j];
				b[i]=b[i]-l*b[k];
			}
			System.out.println("第"+k+"次消元后：");
			PrintA();
		}
				
	}
    public static void Back()//回代
    {
    	x[n-1]=b[n-1]/a[n-1][n-1];
    	for(int i=n-2;i>=0;i--)
    		x[i]=(b[i]-jisuan(i))/a[i][i];
    }
    public static double jisuan(int i){
    	double he=0.0;
    	for(int j=i;j<=n-1;j++)
    		he=he+x[j]*a[i][j];
    	return he;
    }
    public static void Wrap(int k){//换行
    	double max=Math.abs(a[k][k]);
    	int n1=k;                   //记住要交换的行
    	for(int i=k+1;i<n;i++)     //找到要交换的行
    	{
    		if(Math.abs(a[i][k])>max){
    			n1=i;
    			max=Math.abs(a[i][k]);
    		}
    	}
    	if(n1!=k)
    	{
    		n2++;
    	System.out.println("当k="+k+"时,要交换的行是："+k+"和"+n1);
    	for(int j=k;j<n;j++)  //交换a的行
    	{
    		double x1;
    		x1=a[k][j];
    		a[k][j]=a[n1][j];
    		a[n1][j]=x1;
    	}
    	double b1;   //交换b的行
		b1=b[k];
		b[k]=b[n1];
		b[n1]=b1;
		System.out.println("交换后：");
		PrintA();
    	}
    }
    public static void Determinant(){//求行列式
    	double DM=1.0;
    	for(int i=0;i<n;i++)
    	{
    		double a2=a[i][i];
    	    DM=DM*a2;
    	}
    	double n3=(double)n2;
    	DM=DM*Math.pow(-1.0, n3);
    	System.out.println("该方程组的系数行列式：det A = "+DM);
    }
    public static void PrintA(){//输出增广矩阵
    	System.out.println("增广矩阵为：");
    	for(int i=0;i<n;i++)
    	{
    		for(int j=0;j<n;j++)
    			System.out.print(a[i][j]+"    ");
    		System.out.print(b[i]+"    ");
    		System.out.print("\n");
    	}
    }
    public static double[] Print(){//输出方程的根

    	double[] arr=new double[n];
    	for(int i=0;i<n;i++) {
    		arr[i]=x[i];
    	}
    		return arr;
    	//	System.out.println("x"+i+" = "+x[i]);
    }
    //该算法实现解线性方程组
    public static double[] solveEquations(double[][] arr,double[] arr1){
    	n=arr.length;
    	a=arr;
    	b=arr1;
    	x=new double[n];
    	
    	 Elimination();
         Back();
         Print();
         Determinant();
    	return Print();
    }
    
//    
//	public static void main(String[] args) {
//		double inputA[][] = {{1,1,1},{2,1,1},{1,1,-1}};
//		 double inputB[] = {6,7,0};
//		 double[] a=solveEquations(inputA, inputB);
//		 for(int i=0;i<a.length;i++) {
//			 System.out.println(a[i]);
//		 }
//	}
}