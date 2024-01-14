import java.util.List;

public class InfoClass {
	public static <T> void getObjectInfo(T obj) {
		System.out.println(obj.toString());
	}
	public static <E> void getListInfo(List<E> list) {
		for(E x: list) {
			System.out.println(x);
		}
	}
}
