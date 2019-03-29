package exceptions;

/**
 * Thrown if something is unexpectedly wrong with the source data.
 * 
 * @author alessandro.adamou
 *
 */


public class DataFormatException extends Exception {

	private static final long serialVersionUID = -1236411603494051855L;

	private Object data;

	public DataFormatException(String message) {
		super(message);
	}

	public DataFormatException(String message, Object data) {
		super(message);
		this.data = data;
	}

	public Object getData() {
		return data;
	}

}
