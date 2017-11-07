/**
 * InputConsulta.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri.WebServOrdersTransactional.ServOrdersTransactional;

public class InputConsulta  implements java.io.Serializable {
    private org.tempuri.WebServOrdersTransactional.ServOrdersTransactional.Cuenta cuenta;

    private java.lang.String telefono;

    private java.lang.String sku;

    private int no_transaccion_recarga;

    private java.lang.String fecha_hora_recarga;

    private int no_transaccion;

    private java.lang.String fecha_hora;

    public InputConsulta() {
    }

    public InputConsulta(
           org.tempuri.WebServOrdersTransactional.ServOrdersTransactional.Cuenta cuenta,
           java.lang.String telefono,
           java.lang.String sku,
           int no_transaccion_recarga,
           java.lang.String fecha_hora_recarga,
           int no_transaccion,
           java.lang.String fecha_hora) {
           this.cuenta = cuenta;
           this.telefono = telefono;
           this.sku = sku;
           this.no_transaccion_recarga = no_transaccion_recarga;
           this.fecha_hora_recarga = fecha_hora_recarga;
           this.no_transaccion = no_transaccion;
           this.fecha_hora = fecha_hora;
    }


    /**
     * Gets the cuenta value for this InputConsulta.
     * 
     * @return cuenta
     */
    public org.tempuri.WebServOrdersTransactional.ServOrdersTransactional.Cuenta getCuenta() {
        return cuenta;
    }


    /**
     * Sets the cuenta value for this InputConsulta.
     * 
     * @param cuenta
     */
    public void setCuenta(org.tempuri.WebServOrdersTransactional.ServOrdersTransactional.Cuenta cuenta) {
        this.cuenta = cuenta;
    }


    /**
     * Gets the telefono value for this InputConsulta.
     * 
     * @return telefono
     */
    public java.lang.String getTelefono() {
        return telefono;
    }


    /**
     * Sets the telefono value for this InputConsulta.
     * 
     * @param telefono
     */
    public void setTelefono(java.lang.String telefono) {
        this.telefono = telefono;
    }


    /**
     * Gets the sku value for this InputConsulta.
     * 
     * @return sku
     */
    public java.lang.String getSku() {
        return sku;
    }


    /**
     * Sets the sku value for this InputConsulta.
     * 
     * @param sku
     */
    public void setSku(java.lang.String sku) {
        this.sku = sku;
    }


    /**
     * Gets the no_transaccion_recarga value for this InputConsulta.
     * 
     * @return no_transaccion_recarga
     */
    public int getNo_transaccion_recarga() {
        return no_transaccion_recarga;
    }


    /**
     * Sets the no_transaccion_recarga value for this InputConsulta.
     * 
     * @param no_transaccion_recarga
     */
    public void setNo_transaccion_recarga(int no_transaccion_recarga) {
        this.no_transaccion_recarga = no_transaccion_recarga;
    }


    /**
     * Gets the fecha_hora_recarga value for this InputConsulta.
     * 
     * @return fecha_hora_recarga
     */
    public java.lang.String getFecha_hora_recarga() {
        return fecha_hora_recarga;
    }


    /**
     * Sets the fecha_hora_recarga value for this InputConsulta.
     * 
     * @param fecha_hora_recarga
     */
    public void setFecha_hora_recarga(java.lang.String fecha_hora_recarga) {
        this.fecha_hora_recarga = fecha_hora_recarga;
    }


    /**
     * Gets the no_transaccion value for this InputConsulta.
     * 
     * @return no_transaccion
     */
    public int getNo_transaccion() {
        return no_transaccion;
    }


    /**
     * Sets the no_transaccion value for this InputConsulta.
     * 
     * @param no_transaccion
     */
    public void setNo_transaccion(int no_transaccion) {
        this.no_transaccion = no_transaccion;
    }


    /**
     * Gets the fecha_hora value for this InputConsulta.
     * 
     * @return fecha_hora
     */
    public java.lang.String getFecha_hora() {
        return fecha_hora;
    }


    /**
     * Sets the fecha_hora value for this InputConsulta.
     * 
     * @param fecha_hora
     */
    public void setFecha_hora(java.lang.String fecha_hora) {
        this.fecha_hora = fecha_hora;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof InputConsulta)) return false;
        InputConsulta other = (InputConsulta) obj;
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
            ((this.telefono==null && other.getTelefono()==null) || 
             (this.telefono!=null &&
              this.telefono.equals(other.getTelefono()))) &&
            ((this.sku==null && other.getSku()==null) || 
             (this.sku!=null &&
              this.sku.equals(other.getSku()))) &&
            this.no_transaccion_recarga == other.getNo_transaccion_recarga() &&
            ((this.fecha_hora_recarga==null && other.getFecha_hora_recarga()==null) || 
             (this.fecha_hora_recarga!=null &&
              this.fecha_hora_recarga.equals(other.getFecha_hora_recarga()))) &&
            this.no_transaccion == other.getNo_transaccion() &&
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
        if (getTelefono() != null) {
            _hashCode += getTelefono().hashCode();
        }
        if (getSku() != null) {
            _hashCode += getSku().hashCode();
        }
        _hashCode += getNo_transaccion_recarga();
        if (getFecha_hora_recarga() != null) {
            _hashCode += getFecha_hora_recarga().hashCode();
        }
        _hashCode += getNo_transaccion();
        if (getFecha_hora() != null) {
            _hashCode += getFecha_hora().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(InputConsulta.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/WebServOrdersTransactional/ServOrdersTransactional", "InputConsulta"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cuenta");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/WebServOrdersTransactional/ServOrdersTransactional", "cuenta"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/WebServOrdersTransactional/ServOrdersTransactional", "Cuenta"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("telefono");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/WebServOrdersTransactional/ServOrdersTransactional", "telefono"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sku");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/WebServOrdersTransactional/ServOrdersTransactional", "sku"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("no_transaccion_recarga");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/WebServOrdersTransactional/ServOrdersTransactional", "no_transaccion_recarga"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fecha_hora_recarga");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/WebServOrdersTransactional/ServOrdersTransactional", "fecha_hora_recarga"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("no_transaccion");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/WebServOrdersTransactional/ServOrdersTransactional", "no_transaccion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
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
