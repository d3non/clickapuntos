/**
 * InputReverso.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri.WebServOrdersTransactional.ServOrdersTransactional;

public class InputReverso  implements java.io.Serializable {
    private org.tempuri.WebServOrdersTransactional.ServOrdersTransactional.Cuenta cuenta;

    private java.lang.String telefono;

    private java.lang.String sku;

    private int no_transaccion_recarga;

    private java.lang.String fecha_hora_recarga;

    private int no_transaccion;

    private int no_autorizacion_recarga;

    private java.lang.String fecha_hora;

    private java.lang.String cve_estado;

    public InputReverso() {
    }

    public InputReverso(
           org.tempuri.WebServOrdersTransactional.ServOrdersTransactional.Cuenta cuenta,
           java.lang.String telefono,
           java.lang.String sku,
           int no_transaccion_recarga,
           java.lang.String fecha_hora_recarga,
           int no_transaccion,
           int no_autorizacion_recarga,
           java.lang.String fecha_hora,
           java.lang.String cve_estado) {
           this.cuenta = cuenta;
           this.telefono = telefono;
           this.sku = sku;
           this.no_transaccion_recarga = no_transaccion_recarga;
           this.fecha_hora_recarga = fecha_hora_recarga;
           this.no_transaccion = no_transaccion;
           this.no_autorizacion_recarga = no_autorizacion_recarga;
           this.fecha_hora = fecha_hora;
           this.cve_estado = cve_estado;
    }


    /**
     * Gets the cuenta value for this InputReverso.
     * 
     * @return cuenta
     */
    public org.tempuri.WebServOrdersTransactional.ServOrdersTransactional.Cuenta getCuenta() {
        return cuenta;
    }


    /**
     * Sets the cuenta value for this InputReverso.
     * 
     * @param cuenta
     */
    public void setCuenta(org.tempuri.WebServOrdersTransactional.ServOrdersTransactional.Cuenta cuenta) {
        this.cuenta = cuenta;
    }


    /**
     * Gets the telefono value for this InputReverso.
     * 
     * @return telefono
     */
    public java.lang.String getTelefono() {
        return telefono;
    }


    /**
     * Sets the telefono value for this InputReverso.
     * 
     * @param telefono
     */
    public void setTelefono(java.lang.String telefono) {
        this.telefono = telefono;
    }


    /**
     * Gets the sku value for this InputReverso.
     * 
     * @return sku
     */
    public java.lang.String getSku() {
        return sku;
    }


    /**
     * Sets the sku value for this InputReverso.
     * 
     * @param sku
     */
    public void setSku(java.lang.String sku) {
        this.sku = sku;
    }


    /**
     * Gets the no_transaccion_recarga value for this InputReverso.
     * 
     * @return no_transaccion_recarga
     */
    public int getNo_transaccion_recarga() {
        return no_transaccion_recarga;
    }


    /**
     * Sets the no_transaccion_recarga value for this InputReverso.
     * 
     * @param no_transaccion_recarga
     */
    public void setNo_transaccion_recarga(int no_transaccion_recarga) {
        this.no_transaccion_recarga = no_transaccion_recarga;
    }


    /**
     * Gets the fecha_hora_recarga value for this InputReverso.
     * 
     * @return fecha_hora_recarga
     */
    public java.lang.String getFecha_hora_recarga() {
        return fecha_hora_recarga;
    }


    /**
     * Sets the fecha_hora_recarga value for this InputReverso.
     * 
     * @param fecha_hora_recarga
     */
    public void setFecha_hora_recarga(java.lang.String fecha_hora_recarga) {
        this.fecha_hora_recarga = fecha_hora_recarga;
    }


    /**
     * Gets the no_transaccion value for this InputReverso.
     * 
     * @return no_transaccion
     */
    public int getNo_transaccion() {
        return no_transaccion;
    }


    /**
     * Sets the no_transaccion value for this InputReverso.
     * 
     * @param no_transaccion
     */
    public void setNo_transaccion(int no_transaccion) {
        this.no_transaccion = no_transaccion;
    }


    /**
     * Gets the no_autorizacion_recarga value for this InputReverso.
     * 
     * @return no_autorizacion_recarga
     */
    public int getNo_autorizacion_recarga() {
        return no_autorizacion_recarga;
    }


    /**
     * Sets the no_autorizacion_recarga value for this InputReverso.
     * 
     * @param no_autorizacion_recarga
     */
    public void setNo_autorizacion_recarga(int no_autorizacion_recarga) {
        this.no_autorizacion_recarga = no_autorizacion_recarga;
    }


    /**
     * Gets the fecha_hora value for this InputReverso.
     * 
     * @return fecha_hora
     */
    public java.lang.String getFecha_hora() {
        return fecha_hora;
    }


    /**
     * Sets the fecha_hora value for this InputReverso.
     * 
     * @param fecha_hora
     */
    public void setFecha_hora(java.lang.String fecha_hora) {
        this.fecha_hora = fecha_hora;
    }


    /**
     * Gets the cve_estado value for this InputReverso.
     * 
     * @return cve_estado
     */
    public java.lang.String getCve_estado() {
        return cve_estado;
    }


    /**
     * Sets the cve_estado value for this InputReverso.
     * 
     * @param cve_estado
     */
    public void setCve_estado(java.lang.String cve_estado) {
        this.cve_estado = cve_estado;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof InputReverso)) return false;
        InputReverso other = (InputReverso) obj;
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
            this.no_autorizacion_recarga == other.getNo_autorizacion_recarga() &&
            ((this.fecha_hora==null && other.getFecha_hora()==null) || 
             (this.fecha_hora!=null &&
              this.fecha_hora.equals(other.getFecha_hora()))) &&
            ((this.cve_estado==null && other.getCve_estado()==null) || 
             (this.cve_estado!=null &&
              this.cve_estado.equals(other.getCve_estado())));
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
        _hashCode += getNo_autorizacion_recarga();
        if (getFecha_hora() != null) {
            _hashCode += getFecha_hora().hashCode();
        }
        if (getCve_estado() != null) {
            _hashCode += getCve_estado().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(InputReverso.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/WebServOrdersTransactional/ServOrdersTransactional", "InputReverso"));
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
        elemField.setFieldName("no_autorizacion_recarga");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/WebServOrdersTransactional/ServOrdersTransactional", "no_autorizacion_recarga"));
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
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cve_estado");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/WebServOrdersTransactional/ServOrdersTransactional", "cve_estado"));
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
