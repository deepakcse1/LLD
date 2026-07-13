package DocumentEditor;

import java.util.List;

public class DocumentEditor_Naive {
  List<String> documents;
  void addText(String text) {
    documents.add(text);
  }
  void addImage(String imagePath) {
    documents.add(imagePath);
  }
  String render() {
    StringBuilder sb = new StringBuilder();
    for (String doc : documents) {
      if (doc.endsWith(".jpg") || doc.endsWith(".png")) {
        sb.append("<img src=\"").append(doc).append("\" />\n");
      } else {
        sb.append("<p>").append(doc).append("</p>\n");
      }
      // sb.append(doc).append("\n");
    }
    return sb.toString();
  }
  void saveToFile(String filePath) {
    // Save the rendered document to a file
    // String renderedContent = render();
    // Code to write renderedContent to the specified filePath
  }
}
