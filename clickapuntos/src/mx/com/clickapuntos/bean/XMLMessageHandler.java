package mx.com.clickapuntos.bean;
 
import java.io.ByteArrayInputStream;
import java.io.StringReader;
import java.io.StringWriter;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;


public class XMLMessageHandler
{
  private Element rootnode = null;

  private static Logger trace = Logger.getLogger(XMLMessageHandler.class);

  private String srootnode = null;

  public Document document = null;
  private DocumentBuilder builder = null;
  private static final String tempheader_utf8 = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>";
  private static final String tempheader_iso88591 = "<?xml version=\"1.0\" encoding=\"ISO-8859-1\"?>";
  private String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>";
  private String codification = "UTF-8";

  public XMLMessageHandler()
    throws Exception
  {
  }

  public void setCodification(String cod)
    throws Exception
  {
    this.codification = cod;

    if (cod.toUpperCase().equals("UTF-8")) {
      this.header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>";
    }
    else if (cod.toUpperCase().equals("ISO-8859-1")) {
      this.header = "<?xml version=\"1.0\" encoding=\"ISO-8859-1\"?>";
    }
    else {
      this.header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>";
      if (trace.isEnabledFor(Level.WARN)) {
        trace.warn("Se ha pasado una codificacion '" + cod + "' no reconocida, tomando 'UTF-8' como codificacion por defecto");
      }
      this.codification = "UTF-8";
    }
  }

  public XMLMessageHandler(Element root)
  {
    this.rootnode = root;
  }

  public XMLMessageHandler(String sroot)
    throws Exception
  {
    this.srootnode = sroot;
    DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

    dbf.setValidating(false);
    DocumentBuilder db = dbf.newDocumentBuilder();
    Document doc = db.parse(new ByteArrayInputStream(sroot.getBytes()));
    this.rootnode = doc.getDocumentElement();
  }

  public XMLMessageHandler(byte[] in)
    throws Exception
  {
    DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

    dbf.setValidating(false);
    DocumentBuilder db = dbf.newDocumentBuilder();
    Document doc = db.parse(new ByteArrayInputStream(in));
    this.rootnode = doc.getDocumentElement();
  }

  public boolean existElement(String name)
    throws Exception
  {
    if (trace.isEnabledFor(Level.DEBUG))
      trace.debug("Entrando método existElement con el argumento: \nName: " + 
        name);
    boolean st;

    if (this.rootnode.getElementsByTagName(name).item(0) != null)
      st = true;
    else
      st = false;
    if (trace.isEnabledFor(Level.DEBUG)) {
      trace.debug("El elemento '" + name + ", " + st + " existe");
    }
    if (trace.isEnabledFor(Level.DEBUG)) {
      trace.debug("Saliendo método existElement");
    }
    return st;
  }

  protected String getVarValue(String name)
    throws Exception
  {
    if (trace.isEnabledFor(Level.DEBUG)) {
      trace.debug("Entrando método getVarValue con el argumento:\nName: " + 
        name);
    }
    String valor = null;

    if ((this.rootnode.getElementsByTagName(name).item(0) != null) && 
      (this.rootnode.getElementsByTagName(name).item(0).getFirstChild() != null)) {
      valor = this.rootnode.getElementsByTagName(name).item(0).getFirstChild().getNodeValue();
    }

    if (trace.isEnabledFor(Level.DEBUG)) {
      trace.debug("Valor del elemento '" + name + ", = '" + valor + ",");
    }
    if (trace.isEnabledFor(Level.DEBUG)) {
      trace.debug("Saliendo método getVarValue");
    }
    return valor;
  }

  protected boolean existAttr(String nodoName, String attrName)
    throws Exception
  {
    if (trace.isEnabledFor(Level.DEBUG)) {
      trace.debug("Entrando método existAttr con los argumentos: \nNodoName: " + 
        nodoName + "\n" + 
        "AttrName: " + attrName);
    }
    String valor = null;
    boolean st = false;

    if ((this.rootnode.getElementsByTagName(nodoName).item(0) != null) && 
      (this.rootnode.getElementsByTagName(nodoName).item(0).getAttributes() != null) && 
      (this.rootnode.getElementsByTagName(nodoName).item(0).getAttributes().getNamedItem(attrName) != null)) {
      st = true;
    }

    if (trace.isEnabledFor(Level.DEBUG)) {
      trace.debug("Valor del atributo '" + attrName + "', elemento '" + nodoName + ", = '" + valor + ",");
    }
    if (trace.isEnabledFor(Level.DEBUG)) {
      trace.debug("Saliendo método existAttr");
    }
    return st;
  }

  protected String getAttrValue(String nodoName, String attrName)
    throws Exception
  {
    if (trace.isEnabledFor(Level.DEBUG)) {
      trace.debug("Entrando método getAttrValue con los argumentos: \nNodoName: " + 
        nodoName + "\n" + 
        "AttrName: " + attrName);
    }
    String valor = null;
    if ((this.rootnode.getElementsByTagName(nodoName).item(0) != null) && 
      (this.rootnode.getElementsByTagName(nodoName).item(0).getAttributes() != null) && 
      (this.rootnode.getElementsByTagName(nodoName).item(0).getAttributes().getNamedItem(attrName) != null)) {
      valor = this.rootnode.getElementsByTagName(nodoName).item(0).getAttributes().getNamedItem(attrName).getNodeValue();
    }

    if (trace.isEnabledFor(Level.DEBUG)) {
      trace.debug("Valor del atributo '" + attrName + "', elemento '" + nodoName + ", = '" + valor + ",");
    }
    if (trace.isEnabledFor(Level.DEBUG)) {
      trace.debug("Saliendo método getAttrValue");
    }
    return valor;
  }

  protected Integer getAttrIntegerValue(String nodoName, String attrName)
    throws Exception
  {
    if (trace.isEnabledFor(Level.DEBUG)) {
      trace.debug("Entrando método getAttrIntegerValue con el valor: \nNodoName: " + 
        nodoName + "\n" + 
        "AttrName: " + attrName);
    }
    String aux = getAttrValue(nodoName, attrName);
    Integer i = null;

    if (aux != null) {
      try {
        i = new Integer(aux);
      }
      catch (NumberFormatException e) {
        if (trace.isEnabledFor(Level.WARN)) {
          trace.warn("El dato recuperado no es entero", e);
        }
        if (trace.isEnabledFor(Level.DEBUG)) {
          trace.debug("Saliendo método getAttrIntegerValue");
        }
        throw new Exception("El atributo '" + attrName + "' del nodo '" + nodoName + "' no es un entero");
      }
    }
    if (trace.isEnabledFor(Level.DEBUG)) {
      trace.debug("Saliendo método getAttrIntegerValue");
    }
    return i;
  }

  protected Integer getIntegerValue(String name)
    throws Exception
  {
    if (trace.isEnabledFor(Level.DEBUG)) {
      trace.debug("Entrando método getIntegerValue con el argumento: \nName: " + 
        name);
    }
    String aux = null;
    Integer i = null;

    if ((this.rootnode.getElementsByTagName(name).item(0) != null) && 
      (this.rootnode.getElementsByTagName(name).item(0).getFirstChild() != null)) {
      aux = this.rootnode.getElementsByTagName(name).item(0).getFirstChild().getNodeValue();
    }

    if (aux != null) {
      try {
        i = new Integer(aux);
      }
      catch (NumberFormatException e) {
        if (trace.isEnabledFor(Level.WARN)) {
          trace.warn("El atributo '" + name + "' no es un entero", e);
        }
        throw new Exception("El atributo '" + name + "' no es un entero");
      }
    }
    if (trace.isEnabledFor(Level.DEBUG)) {
      trace.debug("Saliendo método getIntegerValue");
    }
    return i;
  }

  public String getXMLString()
    throws Exception
  {
    if (trace.isEnabledFor(Level.INFO)) {
      trace.info("Entrando método getXMLString");
    }

    if (this.srootnode != null) {
      return this.srootnode;
    }
    if (trace.isEnabledFor(Level.INFO)) {
      trace.info("Obteniendo Factory");
    }
    TransformerFactory tFactory = TransformerFactory.newInstance();
    Transformer transformer = tFactory.newTransformer();

    if (trace.isEnabledFor(Level.DEBUG)) {
      trace.debug("Estableciendo codificacion a " + this.codification);
    }
    transformer.setOutputProperty("encoding", this.codification);

    StringWriter st = new StringWriter();

    if (trace.isEnabledFor(Level.INFO)) {
      trace.info("Creando origen y destino DOM");
    }

    DOMSource source = new DOMSource(this.rootnode);

    StreamResult result = new StreamResult(st);
    if (trace.isEnabledFor(Level.INFO)) {
      trace.info("Realizando transformación");
    }
    transformer.transform(source, result);
    String xml = new String(st.toString().getBytes(this.codification));
    if (trace.isEnabledFor(Level.DEBUG)) {
      trace.debug("XML generado:" + xml);
    }
    if (trace.isEnabledFor(Level.DEBUG)) {
      trace.debug("Saliendo método getXMLString");
    }
    return xml;
  }

  public void generateMessage(String xmltemplate)
    throws Exception
  {
    if (trace.isEnabledFor(Level.DEBUG)) {
      trace.debug("Entrando método generateMessage con el argumento: \nXMLTemplate: " + 
        xmltemplate);
    }

    DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
    builderFactory.setValidating(false);

    this.builder = builderFactory.newDocumentBuilder();
    if (trace.isEnabledFor(Level.DEBUG)) {
      trace.debug("Parseando entrada xml: " + this.header + xmltemplate);
    }
    this.document = this.builder.parse(new InputSource(new StringReader(this.header + xmltemplate)));
    this.rootnode = this.document.getDocumentElement();
    if (trace.isEnabledFor(Level.DEBUG))
      trace.debug("Saliendo método generateMessage");
  }

  public String buildXMLString()
    throws Exception
  {
    if (trace.isEnabledFor(Level.DEBUG)) {
      trace.debug("Entrando método buildXMLString");
    }
    if (trace.isEnabledFor(Level.INFO)) {
      trace.info("Obteniendo Factory");
    }
    TransformerFactory tFactory = TransformerFactory.newInstance();
    Transformer transformer = tFactory.newTransformer();

    if (trace.isEnabledFor(Level.DEBUG)) {
      trace.debug("Estableciendo codificacion a " + this.codification);
    }
    transformer.setOutputProperty("encoding", this.codification);

    StringWriter st = new StringWriter();

    if (trace.isEnabledFor(Level.INFO)) {
      trace.info("Creando origen y destino DOM");
    }
    DOMSource source = new DOMSource(this.document);
    StreamResult result = new StreamResult(st);
    if (trace.isEnabledFor(Level.INFO)) {
      trace.info("Realizando transformación");
    }
    transformer.transform(source, result);

    String xml = new String(st.toString().getBytes(this.codification));
    if (trace.isEnabledFor(Level.DEBUG)) {
      trace.debug("XML generado: " + xml);
    }
    if (trace.isEnabledFor(Level.DEBUG)) {
      trace.debug("Saliendo método buildXMLString");
    }
    return xml;
  }

  protected void setFieldValue(String name, String value)
    throws Exception
  {
    if (trace.isEnabledFor(Level.DEBUG)) {
      trace.debug("Entrando método setFieldValue con los argumentos: \n Name: " + 
        name + "\n" + 
        "Value: " + value);
    }
    if (this.document.getElementsByTagName(name).item(0).getFirstChild() == null) {
      if (trace.isEnabledFor(Level.DEBUG)) {
        trace.debug("Creando nodo: " + name + " = " + value);
      }
      this.document.getElementsByTagName(name).item(0).appendChild(this.document.createTextNode(value));
    }
    else {
      if (trace.isEnabledFor(Level.DEBUG)) {
        trace.debug("Asignando valor: " + name + " = " + value);
      }
      this.document.getElementsByTagName(name).item(0).getFirstChild().setNodeValue(value);
    }
    if (trace.isEnabledFor(Level.DEBUG))
      trace.debug("Saliendo método setFieldValue");
  }

  protected void setFieldAttribute(String nodoName, String attrName, String value)
    throws Exception
  {
    if (trace.isEnabledFor(Level.DEBUG)) {
      trace.debug("Entrando método setFieldAttribute con los argumentos: \nNodoName: " + 
        nodoName + "\n" + 
        "Value: " + value + "\n");
    }
    if (trace.isEnabledFor(Level.DEBUG)) {
      trace.debug("Asignando atributo en: " + nodoName + ", para: " + attrName + " , valor: " + value);
    }
    Element el = (Element)this.document.getElementsByTagName(nodoName).item(0);
    el.setAttribute(attrName, value);
    if (trace.isEnabledFor(Level.DEBUG))
      trace.debug("Saliendo método setFieldAttribute");
  }

  protected void setFieldValue(int i, String name, String value)
    throws Exception
  {
    if (trace.isEnabledFor(Level.DEBUG)) {
      trace.debug("Entrando método setFieldValue con los argumentos: \nI: " + 
        i + "\n" + 
        "Name: " + name + "\n" + 
        "Value: " + value);
    }
    if ((this.document.getElementsByTagName(name) == null) && 
      (trace.isEnabledFor(Level.WARN))) {
      trace.warn("Nodo " + name + " no existe");
    }
    if ((this.document.getElementsByTagName(name).item(i) != null) && 
      (trace.isEnabledFor(Level.WARN))) {
      trace.warn("Elemento " + i + " del nodo " + name + " no existe");
    }
    if (this.document.getElementsByTagName(name).item(i).getFirstChild() == null) {
      if (trace.isEnabledFor(Level.DEBUG)) {
        trace.debug("XMLMessageHandler: Creando nodo: " + name + " = " + value);
      }
      this.document.getElementsByTagName(name).item(i).appendChild(this.document.createTextNode(value));
    }
    else {
      if (trace.isEnabledFor(Level.DEBUG)) {
        trace.debug("XMLMessageHandler: Asignando valor: " + name + " = " + value);
      }
      this.document.getElementsByTagName(name).item(i).getFirstChild().setNodeValue(value);
    }
    if (trace.isEnabledFor(Level.DEBUG))
      trace.debug("Saliendo método setFieldValue");
  }

  protected void setFieldAttribute(int i, String nodoName, String attrName, String value)
    throws Exception
  {
    if (trace.isEnabledFor(Level.DEBUG)) {
      trace.debug("Entrando método setFieldAttribute con los argumentos: \nI: " + 
        i + "\n" + 
        "NodoName: " + nodoName + "\n" + 
        "Value: " + value);
    }
    if (trace.isEnabledFor(Level.DEBUG)) {
      trace.debug("XMLMessageHandler: Asignando atributo en: " + nodoName + ", para: " + attrName + " , valor: " + value);
    }
    Element el = (Element)this.document.getElementsByTagName(nodoName).item(i);
    el.setAttribute(attrName, value);
    if (trace.isEnabledFor(Level.DEBUG))
      trace.debug("Saliendo método setFieldAttribute");
  }

  protected void addField(String nodoName, String name, String value)
    throws Exception
  {
    if (trace.isEnabledFor(Level.DEBUG)) {
      trace.debug("Entrando método addField con el argumento: \nNodoName: " + 
        nodoName + "\n" + 
        "Value: " + value);
    }
    if (trace.isEnabledFor(Level.DEBUG)) {
      trace.debug("Creando nuevo nodo en: " + nodoName + ", para: " + name + " , valor: " + value);
    }
    Element root = (Element)this.document.getElementsByTagName(nodoName).item(0);
    Element newElement = this.document.createElement(name);
    if (value != null) {
      newElement.appendChild(this.document.createTextNode(value));
    }
    if (trace.isEnabledFor(Level.INFO)) {
      trace.info("Añadiendo nodo");
    }
    root.appendChild(newElement);
    if (trace.isEnabledFor(Level.DEBUG))
      trace.debug("Saliendo método addField");
  }

  protected void addField(String nodoNameroot, String nodoref, String name, String value)
    throws Exception
  {
    if (trace.isEnabledFor(Level.DEBUG)) {
      trace.debug("Entrando método addField con los argumentos: \nNodoNameRoot: " + 
        nodoNameroot + "\n" + 
        "NodoRef: " + nodoref + "\n" + 
        "Name: " + name + "\n" + 
        "Value: " + value);
    }
    if (trace.isEnabledFor(Level.DEBUG)) {
      trace.debug("Creando nuevo nodo en: " + nodoNameroot + ", para: " + name + " , valor: " + value);
    }
    Element root = (Element)this.document.getElementsByTagName(nodoNameroot).item(0);
    Element ref = (Element)this.document.getElementsByTagName(nodoref).item(0);
    Element newElement = this.document.createElement(name);
    if (value != null)
      newElement.appendChild(this.document.createTextNode(value));
    if (trace.isEnabledFor(Level.DEBUG)) {
      trace.debug("Insertando nodo antes del nodo " + nodoref);
    }
    root.insertBefore(newElement, ref);
    if (trace.isEnabledFor(Level.DEBUG))
      trace.debug("Saliendo método addField");
  }

  protected void delField(String nodoNameroot, String name)
    throws Exception
  {
    if (trace.isEnabledFor(Level.DEBUG)) {
      trace.debug("Entrando método delField con los argumentos: \nNodoNameRoot: " + 
        nodoNameroot + "\n" + 
        "Name: " + name);
    }
    if (trace.isEnabledFor(Level.DEBUG)) {
      trace.debug("Borrando nodo en: " + nodoNameroot + ", para: " + name);
    }
    Element del = (Element)this.document.getElementsByTagName(name).item(0);
    Element root = (Element)this.document.getElementsByTagName(nodoNameroot).item(0);
    root.removeChild(del);
    if (trace.isEnabledFor(Level.DEBUG))
      trace.debug("Saliendo método delField");
  }

  protected void addField(int i, String nodoName, String name, String value)
    throws Exception
  {
    if (trace.isEnabledFor(Level.DEBUG)) {
      trace.debug("Entrando método addField con los argumentos: \nI: " + 
        i + "\n" + 
        "NodoName: " + nodoName + "\n" + 
        "Name: " + name + "\n" + 
        "Value: " + value);
    }
    if (trace.isEnabledFor(Level.DEBUG)) {
      trace.debug("XMLMessageHandler: Creando nuevo nodo en: " + nodoName + ", para: " + name + " , valor: " + value);
    }
    Element root = (Element)this.document.getElementsByTagName(nodoName).item(i);
    Element newElement = this.document.createElement(name);
    if (value != null) {
      newElement.appendChild(this.document.createTextNode(value));
    }
    if (trace.isEnabledFor(Level.INFO)) {
      trace.info("XMLMessageHandler: Añadiendo nodo");
    }
    root.appendChild(newElement);
    if (trace.isEnabledFor(Level.DEBUG))
      trace.debug("Saliendo método addField");
  }

  protected void addNode(int i, String nodoName, String name, Node nodo)
    throws Exception
  {
    if (trace.isEnabledFor(Level.DEBUG)) {
      trace.debug("Entrando método addNode con los argumentos: \nI: " + 
        i + "\n" + 
        "NodoName: " + nodoName + "\n" + 
        "Name: " + name + "\n" + 
        "Nodo: " + nodo);
    }
    if (trace.isEnabledFor(Level.DEBUG)) {
      trace.debug("XMLMessageHandler: Creando nuevo nodo en: " + nodoName + ", para: " + name + " , valor: " + nodo);
    }
    Element root = (Element)this.document.getElementsByTagName(nodoName).item(i);
    if (trace.isEnabledFor(Level.INFO)) {
      trace.info("XMLMessageHandler: Añadiendo nodo");
    }
    root.appendChild(nodo);
    if (trace.isEnabledFor(Level.DEBUG))
      trace.debug("Saliendo método addNode");
  }

  protected void addAttrField(String nodoName, String attrName, String value)
    throws Exception
  {
    if (trace.isEnabledFor(Level.DEBUG))
    {
      trace.debug("Entrando método addAttrField con los argumentos: \nNodo Name: " + 
        nodoName + "\n" + 
        "Attribute Name: " + attrName + "\n" + 
        "Value: " + value);
    }
    if (trace.isEnabledFor(Level.DEBUG)) {
      trace.debug("Añadiendo nuevo atributo: " + attrName + " con valor: " + value + ", en el Nodo: " + nodoName);
    }
    Element root = (Element)this.document.getElementsByTagName(nodoName).item(0);
    Attr newAttr = this.document.createAttribute(attrName);

    if (value != null)
    {
      newAttr.appendChild(this.document.createTextNode(value));
      root.setAttribute(attrName, value);
      if (trace.isEnabledFor(Level.INFO)) {
        trace.info("Atributo añadido");
      }
    }
    if (trace.isEnabledFor(Level.DEBUG))
      trace.debug("Saliendo método addAttrField");
  }

  protected String putDTDURL(String plantilla, String var, String val)
    throws Exception
  {
    if (trace.isEnabledFor(Level.DEBUG)) {
      trace.debug("Entrando método putDTDURL con los argumentos: \nPlantilla: " + 
        plantilla + "\n" + 
        "Var: " + var + "\n" + 
        "Val: " + val);
    }
    StringBuffer mensaje = new StringBuffer(plantilla);
    int pos = 0;
    int from = 0;

    while (pos != -1) {
      pos = mensaje.toString().indexOf(var, from);

      if (pos != -1) {
        from = pos;
        mensaje.delete(pos, pos + var.length());
        mensaje.insert(pos, val);
      }
    }
    if (trace.isEnabledFor(Level.DEBUG)) {
      trace.debug("Saliendo método putDTDURL");
    }
    return mensaje.toString();
  }
}

/* Location:           C:\Hal Cash\Demo\Altcempet y Autcadpet\Altcempet y Autcadpet\
 * Qualified Name:     sesion.XMLMessageHandler
 * JD-Core Version:    0.5.4
 */