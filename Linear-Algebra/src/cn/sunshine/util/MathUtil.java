package cn.sunshine.util;



public class MathUtil {
	// 把字符串转化为数行列式,改行列式行和列相等
	public static double[][] arryParser(String s) {
		double[][] d;
		String[] aFirst = s.split("\n");
		d = new double[aFirst.length][];
		System.out.println(aFirst.length);
		for (int i = 0; i < aFirst.length; i++) {
			String[] aSecond = aFirst[i].split(" ");
			// 如果数据格式不合规，提醒用户
			if (aFirst.length != aSecond.length) {
				return null;
			}
//			System.out.println(aSecond.length);
			d[i] = new double[aSecond.length];
			for (int j = 0; j < aSecond.length; j++) {
				// d[i][j]=Integer.parseInt(aSecond[j]);
				d[i][j] = Double.parseDouble(aSecond[j]);
			}

		}
		//把字符串变成矩阵
		

//    //打印二维数组
//    for(int i=0; i<d.length; i++) {
//        for(int j=0; j<d[i].length; j++) {
//            System.out.print(d[i][j] + "\t");// "\t"代表一个制表位
//        }
//        System.out.println();
//    }

		return d;
	}
	
	
	
	//把字符串变成矩阵
	public static double[][] arryParser1(String s) {
		double[][] d;
		String[] aFirst = s.split("\n");
		d = new double[aFirst.length][];
		System.out.println(aFirst.length);
		for (int i = 0; i < aFirst.length; i++) {
			String[] aSecond = aFirst[i].split(" ");
//			System.out.println(aSecond.length);
			d[i] = new double[aSecond.length];
			for (int j = 0; j < aSecond.length; j++) {
				// d[i][j]=Integer.parseInt(aSecond[j]);
				//判断传来的数据是否符合规范
				if(d[i].length!=d[0].length) {
					return null;
				}
				d[i][j] = Double.parseDouble(aSecond[j]);


			}

		}
		return d;
	}
		
		public static double[][] arryParser2(String s) {
			double[][] d;
			String[] aFirst = s.split("\n");
			d = new double[aFirst.length][];
			System.out.println(aFirst.length);
			for (int i = 0; i < aFirst.length; i++) {
				String[] aSecond = aFirst[i].split(" ");
//				System.out.println(aSecond.length);
				d[i] = new double[aSecond.length];
				for (int j = 0; j < aSecond.length; j++) {
					// d[i][j]=Integer.parseInt(aSecond[j]);
					//判断传来的数据是否符合规范
//					if(d[i].length!=d[0].length) {
//						return null;
//					}
					d[i][j] = Double.parseDouble(aSecond[j]);


				}

			}
		//把字符串变成矩阵
		

//    //打印二维数组
//    for(int i=0; i<d.length; i++) {
//        for(int j=0; j<d[i].length; j++) {
//            System.out.print(d[i][j] + "\t");// "\t"代表一个制表位
//        }
//        System.out.println();
//    }

		return d;
	}

	
	//把字符串变成一维数组
	public static double[] arrayPaser2(String a) {
		
		String[] aFirst = a.split("\n");
		System.out.println(aFirst.length);
		double[] d=new double[aFirst.length];
		for(int i=0;i<aFirst.length;i++) {
			d[i]=Double.parseDouble(aFirst[i]);
			
		}
		return d;
		
	}
	
	 //定义一个功能实现一维数组转字符串
    public static String toString(double[] arr){
        //1.定义个临时容器
        String temp = "[ ";
        //2.遍历数组，字符串自加
        for (int x=0; x<arr.length; ++x){
        	if(x<arr.length-1) {
        		 temp = temp + arr[x]+" , ";	
        	}else {
        		 temp = temp + arr[x];
        	}
           
        }
        return temp+" ]";
    }
    
    
    //定义一个功能实现二维数组转字符串
    public static String toString1(double[][] arr){
        //1.定义个临时容器
        String temp = "[ ";
        //2.遍历数组，字符串自加
        for (int x=0; x<arr.length; ++x){
        	for(int y=0;y<arr[0].length;y++) {
        		
        	
        	if(y<arr[0].length-1) {
        		 temp = temp + arr[x][y]+",";	
        	}else {
        		 temp = temp + arr[x][y];
        	}
        	
        	
        	}
        	temp=temp+"  ;  ";
        	
        }
        return temp+"]";
    }
   
	
	
//传入行列式进行计算，也实现求方阵的模
	public static double fun(double[][] arr) {

		// 最简单的实现

		if (arr.length == 2) {
			return arr[0][0] * arr[1][1] - arr[0][1] * arr[1][0];
		} else if (arr.length == 1) {
			return arr[0][0];
		} else {

			// 获取当前行列式的宽度
			int len = arr.length;
			// 定义一个二维数组 保存稍微简单的数组 就是 少一个宽度的行列式
			double[][] temp = new double[len - 1][len - 1];
			// 此处a，b表示temp数组的索引
			int a, b;
			// 最终结果
			double total = 0;
			// 深度优先 搜索每一种情况
			for (int i = 0; i < len; i++) {
				// 当前值
				double num = arr[0][i];
				// 初始化a，b
				a = 0;
				b = 0;
				// 设置符号
				int sign = (int) Math.pow(-1, i);
				// 进行temp数组赋值
				for (int m = 1; m < len; m++) {
					for (int n = 0; n < len; n++) {
						// 当不是当前列时
						if (n != i) {
							if (b == len - 1) {
								a++;
								b = 0;
							}

							temp[a][b++] = arr[m][n];

						} else {
							continue;
						}
					}
				}
				// 进行深搜 获取值 累加到total上
				total += (sign * num * fun(temp));

			}
			// 返回结果
			return total;

		}

	}

	// 矩阵相加
	public static double[][] add(double[][] m, double[][] n) {
		// 假如传入矩阵不是同型矩阵,则不能相加
		if (m.length != n.length || m[0].length != n[0].length) {
			return null;
		} else {
			double result[][] = new double[m.length][n[0].length];

			for (int i = 0; i < result.length; i++) {
				for (int j = 0; j < result[0].length; j++) {
					result[i][j] = m[i][j] + n[i][j];
				}
			}
			return result;
		}
	}

	// 矩阵相乘
	public static double[][] multiply(double[][] m, double[][] n) {
		// 先判断两个矩阵是否可以进行相乘
		// 如果m的列不等于n的行，或者m的行不等于m的行，则不能相乘，返回null
		if (m.length != n[0].length||m[0].length!=n.length) {
			return null;
		} else {
			double[][] result = new double[m.length][n[0].length];
			for (int i = 0; i < result.length; i++) {
				for (int j = 0; j < result[0].length; j++) {
					for (int k = 0; k < n.length; k++) {
						result[i][j] += (m[i][k] * n[k][j]);
					}

				}
			}
			return result;

		}
	}

	// 矩阵的转置
	public static double[][] transpose(double[][] arr) {
		System.out.println(arr);
		double[][] a = arr;
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[0].length;j++) {
				a[i][j]=arr[i][j];
			}
		}
		double[][] result = new double[a[0].length][a.length];
		for (int i = 0; i < result.length; i++) {
			for (int j = 0; j < result[0].length; j++) {
				result[i][j] = arr[j][i];
			}
		}
		return result;
	}

	
	/**实现逆矩阵
	 * 逆矩阵一定是方阵
	 * 
	 * 思路：1:求出余子式
	 * 2：调用去已写好的求模，转置函数，以及余子式的函数，实现矩阵求逆
	 * 
	 * 
	 */
	//1:求出余子式 m为要求余子式的行，n为要求代数余子式的列
	public static  double[][]  getAlgebraicComplementaryMinor(double[][] arr,int m,int n){
		
		int len=arr.length;
		int len1=arr[0].length;
		//定义新的矩阵接受结果
		double[][] result=new double[len-1][len1-1];
		for(int i=0;i<result.length;i++) {
			if(i<m-1) {
				for(int j=0;j<result[0].length;j++) {
					if(j<n-1) {
						result[i][j]=arr[i][j];
					}else {
						result[i][j]=arr[i][j+1];
					}
				}	
			}else {
				for(int j=0;j<result[0].length;j++) {
					if(j<n-1) {
						result[i][j]=arr[i+1][j];
					}else {
						result[i][j]=arr[i+1][j+1];
					}
				}
				
			}
			
	
		}
		return result;	
	
		}
	
	
	 //实现逆矩阵
	//2：调用去已写好的求模，转置函数，以及代数余子式的函数，实现矩阵求逆
	public static double[][] getMatrixInversion(double[][] arr){
		//定义一个新矩阵接收矩阵的逆
		double[][] result=new double[arr.length][arr[0].length];
		
		//判断是否能进行求逆,一个必须为方阵,一个是矩阵的模不为零
		double m=fun(arr);
		if(arr.length!=arr[0].length) {
			return null;
		}else if(m==0) {
			return null;
		}else {//如果传来的数据符合规定,进行运算
			
			for(int i=0;i<result.length;i++) {
				for(int j=0;j<result[0].length;j++) {
					//传进来余子式，将其变成代数余子式，求它的模
					int a=i+1;
					int b=j+1;
					double num;
					if((a+b)%2==0) {
						num=fun(getAlgebraicComplementaryMinor(arr,a,b));
					}else {
						num=-fun(getAlgebraicComplementaryMinor(arr,a,b));
					}
					result[i][j]=num/m;
				}
			}
			//进行转置
			result=transpose(result);
		}
		return result;
		
	}
	
	
	//由于个人能力的不足,以下方法均为从网上借鉴修改的来的
	//求矩阵的秩
		public static int Rank(double[][] Matrix, int error_, int List) {
			int n = List;
			int m = Matrix.length;
			int i = 0;
			int i1;
			int j = 0;
			int j1;
			double temp1;
			if (m > n) {
				i = m;
				m = n;
				n = i;
				i = 1;
			}
			m -= 1;
			n -= 1;
			double[][] temp = new double[m + 1][n + 1];
			if (i == 0) {
				for (i = 0; i <= m; i++) {
					for (j = 0; j <= n; j++) {
						temp[i][j] = Matrix[i][j];
					}

				}
			} else {
				for (i = 0; i <= m; i++) {
					for (j = 0; j <= n; j++) {
						temp[i][j] = Matrix[j][i];
					}
				}
			}
			if (m == 0) {
				i = 0;
				while (i <= n) {
					if (Matrix[0][i] != 0) {
						return 1;
					}
					i += 1;
				}
				return 0;
			}
			double error0;
			if (error_ == -1) {
				error0 = Math.pow(0.1, 10);
			} else {
				error0 = Math.pow(0.1, error_);
			}
			i = 0;
			while (i <= m) {
				j = 0;
				while (j <= n) {
					if (temp[i][j] != 0) {
						error0 *= temp[i][j];
						i = m;
						break;
					}
					j += 1;
				}
				i += 1;
			}
			double error1;
			for (i = 0; i <= m; i++) {
				j = 0;
				while (j <= n) {
					if (temp[i][j] != 0) {
						break;
					}
					j += 1;
				}
				if (j <= n) {
					i1 = 0;
					while (i1 <= m) {
						if (temp[i1][j] != 0 && i1 != i) {
							temp1 = temp[i][j] / temp[i1][j];
							error1 = Math.abs((temp[i][j] - temp[i1][j] * temp1)) * 100;
							error1 += error0;
							for (j1 = 0; j1 <= n; j1++) {
								temp[i1][j1] = temp[i][j1] - temp[i1][j1] * temp1;
								if (Math.abs(temp[i1][j1]) < error1) {
									temp[i1][j1] = 0;
								}
							}

						}
						i1 += 1;
					}
				}
			}

			i1 = 0;
			for (i = 0; i <= m; i++) {
				for (j = 0; j <= n; j++) {
					if (temp[i][j] != 0) {
						i1 += 1;
						break;
					}
				}
			}
			return i1;
		}
		
		
	
		
		
	
}
