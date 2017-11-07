/**
 * InputSaldo.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri.WebServOrdersTransactional.ServOrdersTransactional;

public class InputSaldo  implements java.io.Serializable {
    private org.tempuri.WebServOrdersTransactional.ServOrdersTransactional.Cuenta cuenta;

    private java.lang.String fecha_hora;

    public InputSaldo() {
    }

    public InputSaldo(
           org.tempuri.WebServOrdersTransactional.ServOrdersTransactional.Cuenta cuenta,
           java.lang.String fecha_hora) {
           this.cuenta = cuenta;
           this.fecha_hora = fecha_hora;
    }


    /**
     * Gets the cuenta value for this InputSaldo.
     * 
     * @return cuenta
     */
    public org.tempuri.WebServOrdersTransactional.ServOrdersTransactional.Cuenta getCuenta() {
        return cuenta;
    }


    /**
     * Sets the cuenta value for this InputSaldo.
     * 
     * @param cuenta
     */
    public void setCuenta(org.tempuri.WebServOrdersTransactional.ServOrdersTransactional.Cuenta cuenta) {
        this.cuenta = cuenta;
    }


    /**
     * Gets the fecha_hora value for this InputSaldo.
     * 
     * @return fecha_hora
     */
    public java.lang.String getFecha_hora() {
        return fecha_hora;
    }


    /**
     * Sets the fecha_hora value for this InputSaldo.
     * 
     * @param fecha_hora
     */
    public void setFecha_hora(java.lang.String fecha_hora) {
        this.fecha_hora = fecha_hora;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof InputSaldo)) return false;
        InputSaldo other = (InputSaldo) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.cuenta==null && other.getCuenta()==null) || 
             (this.cuenta!=null &&
              this.cuenta.equals(other.getCuenta()))) &&
            ((this.fecha_hora==null && other.getFecha_hora()==null) || 
             (this.fecha_hora!=null &&
              this.fecha_hora.equals(other.getFecha_hora())));
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
        if (getCuenta() != null) {
            _hashCode += getCuenta().hashCode();
        }
        if (getFecha_hora() != null) {
            _hashCode += getFecha_hora().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(InputSaldo.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/WebServOrdersTransactional/ServOrdersTransactional", "InputSaldo"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cuenta");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/WebServOrdersTransactional/ServOrdersTransactional", "cuenta"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/WebServOrdersTransactional/ServOrdersTransactional", "Cuenta"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fecha_hora");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/WebServOrdersTransactional/ServOrdersTransactional", "fecha_hora"));
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
