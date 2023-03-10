package control;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.List;
import model.Content;

public class HttpGenerator {

	private Writer writer;
	private final String head = """
			<head>
				<meta charset=\"utf-8\">
				<meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">
				<link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css\"
					+ "integrity=\"sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm\" crossorigin=\"anonymous\">
			</head>
			""";
	private final String divTemplate = """
			<div class=\"card text-white bg-dark mb-3\" style=\"max-width: 18rem;\">
				<h4 class=\"card-header\">%s</h4>
				<div class=\"card-body\">
					<figure>
						<img class=\"card-img\" src=\"%s\" alt=\"%s poster\">
						<figcaption>%s</figcaption>
					</figure>
					<p class=\"card-text mt-2\">Nota: %s - Ano: %s</p>
				</div>
			</div>
			""";

	public HttpGenerator(PrintWriter writer) {
		this.writer = writer;
	}

	public void generate(List<? extends Content> contents) {
		try {
			writer.write("<!DOCTYPE html>\n");
			writer.write("<html>\n");
			writer.write(head);
			writer.write("<body>\n");
			for (Content content : contents) {
				String movieBlock = String.format(divTemplate, content.title(), content.urlImage(), content.title(), content.type(),
						content.rating(), content.year());
				writer.write(movieBlock);

			}
			writer.write("</body>\n");
			writer.write("</html>\n");
			writer.flush();
			writer.close();
		} catch (IOException e) {

		}
	}
}
