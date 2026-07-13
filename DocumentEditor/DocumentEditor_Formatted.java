package DocumentEditor;

import java.util.ArrayList;
import java.util.List;

public class DocumentEditor_Formatted {
  
}
interface DocumentElement {
  String render();
}
class TextElement implements DocumentElement {
  private String text;
  public TextElement(String text) {
    this.text = text;
  }
  @Override
  public String render() {
    return "<p>" + text + "</p>\n";
  }
}
class ImageElement implements DocumentElement {
  private String imagePath;
  public ImageElement(String imagePath) {
    this.imagePath = imagePath; 
  }
  @Override
  public String render() {
    return "<img src=\"" + imagePath + "\" />\n";   
  }
}
class NewLineElement implements DocumentElement {
  @Override
  public String render() {
    return "\n";
  }
}
class TabSpaceElement implements DocumentElement {
  @Override
  public String render() {
    return "\t ";
  }
}
class Document {
  private List<DocumentElement> elements;
  public Document() {
    elements = new ArrayList<>();
  }
  public void addElement(DocumentElement element) {
    elements.add(element);
  }
  public String render() {
    StringBuilder sb = new StringBuilder();
    for (DocumentElement element : elements) {
      sb.append(element.render());
    }
    return sb.toString();
  }
}
interface PersistentStorage {
  public void save(String filePath, String content);
}
class FileStorage implements PersistentStorage {
  @Override
  public void save(String filePath, String content) {
    // Code to write content to the specified filePath
  }
}
class DBStorage implements PersistentStorage {
  @Override
  public void save(String filePath, String content) {
    // Code to save content to a database
  }
} 
class DocumentEditor {
  private Document document;
  private PersistentStorage storage;
  public DocumentEditor(PersistentStorage storage) {
    this.document = new Document();
    this.storage = storage;
  }
  public void addText(String text) {
    document.addElement(new TextElement(text));
  }
  public void addImage(String imagePath) {
    document.addElement(new ImageElement(imagePath));
  }
  public void addNewLine() {
    document.addElement(new NewLineElement());
  }
  public void addTabSpace() {
    document.addElement(new TabSpaceElement());
  }
  public String render() {
    return document.render();
  }
  public void saveToFile(String filePath) {
    String renderedContent = render();
    storage.save(filePath, renderedContent);
  }

  public static void main(String[] args) {
    PersistentStorage storage = new FileStorage(); // or new DBStorage();
    DocumentEditor editor = new DocumentEditor(storage);
    editor.addText("Hello, World!");
    editor.addNewLine();
    editor.addImage("image.jpg");
    editor.addTabSpace();
    editor.addText("This is a formatted document.");
    String renderedContent = editor.render();
    System.out.println(renderedContent);
    editor.saveToFile("output.html");
  }
}