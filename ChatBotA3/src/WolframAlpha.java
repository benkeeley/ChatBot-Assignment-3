import com.wolfram.alpha.WAEngine;
import com.wolfram.alpha.WAException;
import com.wolfram.alpha.WAPlainText;
import com.wolfram.alpha.WAPod;
import com.wolfram.alpha.WAQuery;
import com.wolfram.alpha.WAQueryResult;
import com.wolfram.alpha.WASubpod;

public class WolframAlpha {
	private static String appid = "XXXXXXXXXXXXXXXXXXXXXXXXXX";
	private WAEngine engine;
	private WAQuery query;
	private String result;
	private String input;
	private String wikipediaSummary;
	private String topic;

	WolframAlpha() {
		engine = new WAEngine();
		engine.setAppID(appid);
		engine.addFormat("plaintext");
		// Create the query.
		query = engine.createQuery();
		result = null;
		input = null;
		wikipediaSummary = null;
		topic = null;

	}

	public void query(String input) {
		String title;
		try {

			// Set properties of the query.
			query.setInput(input);

			// For educational purposes, print out the URL we are about to send:
			System.out.println("Query URL:");
			System.out.println(engine.toURL(query));
			System.out.println("");

			// This sends the URL to the Wolfram|Alpha server, gets the XML result
			// and parses it into an object hierarchy held by the WAQueryResult object.
			WAQueryResult queryResult = engine.performQuery(query);

			if (queryResult.isError()) {
				System.out.println("Query error");
				System.out.println("  error code: " + queryResult.getErrorCode());
				System.out.println("  error message: " + queryResult.getErrorMessage());
			} else if (!queryResult.isSuccess()) {
				System.out.println("Query was not understood; no results available.");
			} else {
				// Got a result.
				System.out.println("Successful query. Pods follow:\n");
				for (WAPod pod : queryResult.getPods()) {
					if (!pod.isError()) {
						title = pod.getTitle();
						System.out.println(title);
						System.out.println("------------");
						for (WASubpod subpod : pod.getSubpods()) {
							for (Object element : subpod.getContents()) {
								if (element instanceof WAPlainText) {
									if (title.equals("Input")) {
										this.input = ((WAPlainText) element).getText();
									} else if (title.equals("Result")) {
										this.result = ((WAPlainText) element).getText();
									} else if (title.equals("Input interpretation")) {
										try {
											String s = ((WAPlainText) element).getText();
											if (s.lastIndexOf('|') != -1) {
												this.topic = s.substring(0, s.indexOf("|")).trim();
											}

											else {
												this.topic = s.trim();
											}

										} catch (Exception e) {
											System.out.println(e.toString());
											this.topic = null;

										}
									} else if (title.equals("Wikipedia summary")) {
										this.wikipediaSummary = ((WAPlainText) element).getText();
									}
									System.out.println(((WAPlainText) element).getText());
									System.out.println("");
								}
							}
						}
						System.out.println("");
					}
				}
			}
		} catch (WAException e) {
			System.out.println(e.toString());
			this.result = null;
			this.input = null;
			this.wikipediaSummary = null;
			this.topic = null;
		}
	}

	public void setResult(String s) {
		this.result = s;
	}

	public String getResult() {
		return result;
	}

	public String getInput() {
		return input;

	}

	public void setInput(String s) {
		this.input = s;
	}

	public String getWikipediaSummary() {
		return this.wikipediaSummary;
	}

	public void setWikipediaSummary(String s) {
		this.wikipediaSummary = s;
	}

	public String getTopic() {
		return this.topic;
	}

	public void setTopic(String s) {
		this.topic = s;
	}
}
