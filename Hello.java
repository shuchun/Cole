import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Hello{
	public static void main(String[] args){
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
	
}