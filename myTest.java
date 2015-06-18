
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

/**
*单元测试类
*/
public class myTest {
	
	@Test
	public void Test1(){
		String demo="<div id='test' class='class div ' style='color:#aaa;width:55px;>hello world</div>";
	
		//标签验证
		String startTagEx = "^<\\w*\\b";
		List<String> match=new ArrayList<String>();
		match=this.findByRegEx(startTagEx, demo);
		
		String startTag="";//开始标签
		String endTag="</";//结束标签
		
		if(match.size()>0){
			startTag=match.get(0);
			endTag+=startTag.substring(1)+">";
		}else{
			System.out.println("解析失败，未找到匹配的起始标签！");
			return;
		}

		//解析属性
		String attrEx="^"+startTag+"\b*[^>]*>";
		String attr="";
		match=this.findByRegEx(attrEx, demo);
		attr=match.size()>0?match.get(0):"";
		attrEx="\\w+=['|\"|\\w]+\\b*";
		match=this.findByRegEx(attrEx, attr);
		for(String attribute:match){
			System.out.println(attribute);
		}

		//解析内容
		String contentEx=">.*"+endTag+"$";
		String content="";
		match=this.findByRegEx(contentEx, demo);
		content=match.size()>0?match.get(0):"";
		content=content.replace(endTag,"");
		content=content.replace(">","");
		content=content.replace(" ","");
		System.out.println(content);
	}
	
	public List<String> findByRegEx(String regEx,String str){
		Matcher matcher = null;
		Pattern pattern = null;
		pattern = Pattern.compile(regEx);
		matcher = pattern.matcher(str);
		List<String> target=new ArrayList<String>();
		while(matcher.find()){
			target.add(matcher.group());
		}
		
		return target;
	}

	@Test
	public void Test2() {
		
		String[][] data  = {{"1","2","3","4"},{"5","6","7","8"},{"9","10","11","12"}};

		String[][] result = RotatArray(data, 2);
		for (int i = 0; i < result.length; i++) {
			System.out.print("[\t");
			for (int j = 0; j < result[0].length; j++) {
				System.out.print(result[i][j]+"\t");
			}
			System.out.print("]");
			System.out.println();
		}
	}
	

	public String[][] RotatArray(String[][] data,int num){
		
		String newArray[][] = {};
		
		if(num>0){
			int row = data.length-1;
			int col = data[0].length-1;
			newArray = new String[col+1][row+1];
			for (int i = 0; i <= col; i++) {
				for (int j = 0; j <= row; j++) {
					//取
					newArray[i][j]= data[j][col-i];
				}
			}
			newArray = RotatArray(newArray, num-1);
		}else{
			return data;
		}
		
		return newArray;
	}
	
	@Test
	public void test3(){
		Singleton s1=Singleton.newInstance("one");
		System.out.println(s1.getName());
		Singleton s2=Singleton.newInstance("two");
		System.out.println(s1.getName());
		
		System.out.println(s1.equals(s2));
	}	
	
	@Test
	public void test4(){
		String demo="sdfsdf7loiol8sdkf4lksdjfi2";
		
		for(char alpha:demo.toCharArray()){
			if(alpha>='0'&&alpha<='9'){
				System.out.print(alpha);
			}
		}
	}
	
	@Test
	public void test5(){
		int[] demo={1,3,4,7,2,1,1,5,2};
		int max=demo[0];
		int more=demo[0];
		Map<Integer,Integer> count=new HashMap<Integer,Integer>();
		
		for(int i=0;i<demo.length;i++){
			if(count.containsKey(demo[i])){
				int curNum=count.get(demo[i]);
				count.put(demo[i], ++curNum);
			}else{
				count.put(demo[i], 1);
			}
			
			max=max>demo[i]?max:demo[i];//最大
			more=count.get(more)>count.get(demo[i])?more:demo[i];//最多
		}
		
		System.out.println("Max:"+max);
		System.out.println("More:"+more+",Num:"+count.get(more));
		
	}

}
