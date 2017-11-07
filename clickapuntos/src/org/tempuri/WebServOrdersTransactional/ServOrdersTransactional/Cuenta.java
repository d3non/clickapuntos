/**
 * Cuenta.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri.WebServOrdersTransactional.ServOrdersTransactional;

public class Cuenta  implements java.io.Serializable {
    private int cadena;

    private int establecimiento;

    private int terminal;

    private java.lang.String cajero;

    private java.lang.String clave;

    public Cuenta() {
    }

    public Cuenta(
           int cadena,
           int establecimiento,
           int terminal,
           java.lang.String cajero,
           java.lang.String clave) {
           this.cadena = cadena;
           this.establecimiento = establecimiento;
           this.terminal = terminal;
           this.cajero = cajero;
           this.clave = clave;
    }


    /**
     * Gets the cadena value for this Cuenta.
     * 
     * @return cadena
     */
    public int getCadena() {
        return cadena;
    }


    /**
     * Sets the cadena value for this Cuenta.
     * 
     * @param cadena
     */
    public void setCadena(int cadena) {
        this.cadena = cadena;
    }


    /**
     * Gets the establecimiento value for this Cuenta.
     * 
     * @return establecimiento
     */
    public int getEstablecimiento() {
        return establecimiento;
    }


    /**
     * Sets the establecimiento value for this Cuenta.
     * 
     * @param establecimiento
     */
    public void setEstablecimiento(int establecimiento) {
        this.establecimiento = establecimiento;
    }


    /**
     * Gets the terminal value for this Cuenta.
     * 
     * @return terminal
     */
    public int getTerminal() {
        return terminal;
    }


    /**
     * Sets the terminal value for this Cuenta.
     * 
     * @param terminal
     */
    public void setTerminal(int terminal) {
        this.terminal = terminal;
    }


    /**
     * Gets the cajero value for this Cuenta.
     * 
     * @return cajero
     */
    public java.lang.String getCajero() {
        return cajero;
    }


    /**
     * Sets the cajero value for this Cuenta.
     * 
     * @param cajero
     */
    public void setCajero(java.lang.String cajero) {
        this.cajero = cajero;
    }


    /**
     * Gets the clave value for this Cuenta.
     * 
     * @return clave
     */
    public java.lang.String getClave() {
        return clave;
    }


    /**
     * Sets the clave value for this Cuenta.
     * 
     * @param clave
     */
    public void setClave(java.lang.String clave) {
        this.clave = clave;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Cuenta)) return false;
        Cuenta other = (Cuenta) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.cadena == other.getCadena() &&
            this.establecimiento == other.getEstablecimiento() &&
            this.terminal == other.getTerminal() &&
            ((this.cajero==null && other.getCajero()==null) || 
             (this.cajero!=null &&
              this.cajero.equals(other.getCajero()))) &&
            ((this.clave==null && other.getClave()==null) || 
             (this.clave!=null &&
              this.clave.equals(other.getClave())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        _hashCode += getCadena();
        _hashCode += getEstablecimiento();
        _hashCode += getTerminal();
        if (getCajero() != null) {
            _hashCode += getCajero().hashCode();
        }
        if (getClave() != null) {
            _hashCode += getClave().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Cuenta.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/WebServOrdersTransactional/ServOrdersTransactional", "Cuenta"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cadena");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/WebServOrdersTransactional/ServOrdersTransactional", "cadena"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("establecimiento");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/WebServOrdersTransactional/ServOrdersTransactional", "establecimiento"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("terminal");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/WebServOrdersTransactional/ServOrdersTransactional", "terminal"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cajero");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/WebServOrdersTransactional/ServOrdersTransactional", "cajero"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("clave");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/WebServOrdersTransactional/ServOrdersTransactional", "clave"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
