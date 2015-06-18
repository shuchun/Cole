
/**
 * 单例
 *
 */
public class Singleton {
	
	//实例
	private static Singleton instance;
	private String name;

	//首先私有化构造函数，使得该类不可以通过new的方法创建新实例
	private Singleton(String name) {
		this.name=name;
	}
	
	//提供静态公共方法创建新实例
	public static synchronized  Singleton newInstance(String name){
		if(instance==null){
			instance=new Singleton(name);
		}else{
			instance.name=name;
		}
		
		return instance;
	}
	
	//获取实例名称
	public String getName(){
		return this.name;
	}
	
	
}
