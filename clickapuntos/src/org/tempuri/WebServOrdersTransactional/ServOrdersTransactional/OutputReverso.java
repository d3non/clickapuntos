/**
 * OutputReverso.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri.WebServOrdersTransactional.ServOrdersTransactional;

public class OutputReverso  implements java.io.Serializable {
    private org.tempuri.WebServOrdersTransactional.ServOrdersTransactional.Cuenta cuenta;

    private java.lang.String telefono;

    private java.lang.String sku;

    private int no_transaccion;

    private java.lang.String fecha_hora;

    private java.lang.String fecha_hora_solicitud;

    private java.lang.String fecha_hora_respuesta;

    private java.lang.String cve_estado;

    private int codigo_respuesta;

    private java.lang.String descripcion_respuesta;

    private int no_autorizacion;

    public OutputReverso() {
    }

    public OutputReverso(
           org.tempuri.WebServOrdersTransactional.ServOrdersTransactional.Cuenta cuenta,
           java.lang.String telefono,
           java.lang.String sku,
           int no_transaccion,
           java.lang.String fecha_hora,
           java.lang.String fecha_hora_solicitud,
           java.lang.String fecha_hora_respuesta,
           java.lang.String cve_estado,
           int codigo_respuesta,
           java.lang.String descripcion_respuesta,
           int no_autorizacion) {
           this.cuenta = cuenta;
           this.telefono = telefono;
           this.sku = sku;
           this.no_transaccion = no_transaccion;
           this.fecha_hora = fecha_hora;
           this.fecha_hora_solicitud = fecha_hora_solicitud;
           this.fecha_hora_respuesta = fecha_hora_respuesta;
           this.cve_estado = cve_estado;
           this.codigo_respuesta = codigo_respuesta;
           this.descripcion_respuesta = descripcion_respuesta;
           this.no_autorizacion = no_autorizacion;
    }


    /**
     * Gets the cuenta value for this OutputReverso.
     * 
     * @return cuenta
     */
    public org.tempuri.WebServOrdersTransactional.ServOrdersTransactional.Cuenta getCuenta() {
        return cuenta;
    }


    /**
     * Sets the cuenta value for this OutputReverso.
     * 
     * @param cuenta
     */
    public void setCuenta(org.tempuri.WebServOrdersTransactional.ServOrdersTransactional.Cuenta cuenta) {
        this.cuenta = cuenta;
    }


    /**
     * Gets the telefono value for this OutputReverso.
     * 
     * @return telefono
     */
    public java.lang.String getTelefono() {
        return telefono;
    }


    /**
     * Sets the telefono value for this OutputReverso.
     * 
     * @param telefono
     */
    public void setTelefono(java.lang.String telefono) {
        this.telefono = telefono;
    }


    /**
     * Gets the sku value for this OutputReverso.
     * 
     * @return sku
     */
    public java.lang.String getSku() {
        return sku;
    }


    /**
     * Sets the sku value for this OutputReverso.
     * 
     * @param sku
     */
    public void setSku(java.lang.String sku) {
        this.sku = sku;
    }


    /**
     * Gets the no_transaccion value for this OutputReverso.
     * 
     * @return no_transaccion
     */
    public int getNo_transaccion() {
        return no_transaccion;
    }


    /**
     * Sets the no_transaccion value for this OutputReverso.
     * 
     * @param no_transaccion
     */
    public void setNo_transaccion(int no_transaccion) {
        this.no_transaccion = no_transaccion;
    }


    /**
     * Gets the fecha_hora value for this OutputReverso.
     * 
     * @return fecha_hora
     */
    public java.lang.String getFecha_hora() {
        return fecha_hora;
    }


    /**
     * Sets the fecha_hora value for this OutputReverso.
     * 
     * @param fecha_hora
     */
    public void setFecha_hora(java.lang.String fecha_hora) {
        this.fecha_hora = fecha_hora;
    }


    /**
     * Gets the fecha_hora_solicitud value for this OutputReverso.
     * 
     * @return fecha_hora_solicitud
     */
    public java.lang.String getFecha_hora_solicitud() {
        return fecha_hora_solicitud;
    }


    /**
     * Sets the fecha_hora_solicitud value for this OutputReverso.
     * 
     * @param fecha_hora_solicitud
     */
    public void setFecha_hora_solicitud(java.lang.String fecha_hora_solicitud) {
        this.fecha_hora_solicitud = fecha_hora_solicitud;
    }


    /**
     * Gets the fecha_hora_respuesta value for this OutputReverso.
     * 
     * @return fecha_hora_respuesta
     */
    public java.lang.String getFecha_hora_respuesta() {
        return fecha_hora_respuesta;
    }


    /**
     * Sets the fecha_hora_respuesta value for this OutputReverso.
     * 
     * @param fecha_hora_respuesta
     */
    public void setFecha_hora_respuesta(java.lang.String fecha_hora_respuesta) {
        this.fecha_hora_respuesta = fecha_hora_respuesta;
    }


    /**
     * Gets the cve_estado value for this OutputReverso.
     * 
     * @return cve_estado
     */
    public java.lang.String getCve_estado() {
        return cve_estado;
    }


    /**
     * Sets the cve_estado value for this OutputReverso.
     * 
     * @param cve_estado
     */
    public void setCve_estado(java.lang.String cve_estado) {
        this.cve_estado = cve_estado;
    }


    /**
     * Gets the codigo_respuesta value for this OutputReverso.
     * 
     * @return codigo_respuesta
     */
    public int getCodigo_respuesta() {
        return codigo_respuesta;
    }


    /**
     * Sets the codigo_respuesta value for this OutputReverso.
     * 
     * @param codigo_respuesta
     */
    public void setCodigo_respuesta(int codigo_respuesta) {
        this.codigo_respuesta = codigo_respuesta;
    }


    /**
     * Gets the descripcion_respuesta value for this OutputReverso.
     * 
     * @return descripcion_respuesta
     */
    public java.lang.String getDescripcion_respuesta() {
        return descripcion_respuesta;
    }


    /**
     * Sets the descripcion_respuesta value for this OutputReverso.
     * 
     * @param descripcion_respuesta
     */
    public void setDescripcion_respuesta(java.lang.String descripcion_respuesta) {
        this.descripcion_respuesta = descripcion_respuesta;
    }


    /**
     * Gets the no_autorizacion value for this OutputReverso.
     * 
     * @return no_autorizacion
     */
    public int getNo_autorizacion() {
        return no_autorizacion;
    }


    /**
     * Sets the no_autorizacion value for this OutputReverso.
     * 
     * @param no_autorizacion
     */
    public void setNo_autorizacion(int no_autorizacion) {
        this.no_autorizacion = no_autorizacion;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof OutputReverso)) return false;
        OutputReverso other = (OutputReverso) obj;
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
            this.no_transaccion == other.getNo_transaccion() &&
            ((this.fecha_hora==null && other.getFecha_hora()==null) || 
             (this.fecha_hora!=null &&
              this.fecha_hora.equals(other.getFecha_hora()))) &&
            ((this.fecha_hora_solicitud==null && other.getFecha_hora_solicitud()==null) || 
             (this.fecha_hora_solicitud!=null &&
              this.fecha_hora_solicitud.equals(other.getFecha_hora_solicitud()))) &&
            ((this.fecha_hora_respuesta==null && other.getFecha_hora_respuesta()==null) || 
             (this.fecha_hora_respuesta!=null &&
              this.fecha_hora_respuesta.equals(other.getFecha_hora_respuesta()))) &&
            ((this.cve_estado==null && other.getCve_estado()==null) || 
             (this.cve_estado!=null &&
              this.cve_estado.equals(other.getCve_estado()))) &&
            this.codigo_respuesta == other.getCodigo_respuesta() &&
            ((this.descripcion_respuesta==null && other.getDescripcion_respuesta()==null) || 
             (this.descripcion_respuesta!=null &&
              this.descripcion_respuesta.equals(other.getDescripcion_respuesta()))) &&
            this.no_autorizacion == other.getNo_autorizacion();
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
        _hashCode += getNo_transaccion();
        if (getFecha_hora() != null) {
            _hashCode += getFecha_hora().hashCode();
        }
        if (getFecha_hora_solicitud() != null) {
            _hashCode += getFecha_hora_solicitud().hashCode();
        }
        if (getFecha_hora_respuesta() != null) {
            _hashCode += getFecha_hora_respuesta().hashCode();
        }
        if (getCve_estado() != null) {
            _hashCode += getCve_estado().hashCode();
        }
        _hashCode += getCodigo_respuesta();
        if (getDescripcion_respuesta() != null) {
            _hashCode += getDescripcion_respuesta().hashCode();
        }
        _hashCode += getNo_autorizacion();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(OutputReverso.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/WebServOrdersTransactional/ServOrdersTransactional", "OutputReverso"));
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
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fecha_hora_solicitud");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/WebServOrdersTransactional/ServOrdersTransactional", "fecha_hora_solicitud"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fecha_hora_respuesta");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/WebServOrdersTransactional/ServOrdersTransactional", "fecha_hora_respuesta"));
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
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("codigo_respuesta");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/WebServOrdersTransactional/ServOrdersTransactional", "codigo_respuesta"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("descripcion_respuesta");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/WebServOrdersTransactional/ServOrdersTransactional", "descripcion_respuesta"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("no_autorizacion");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/WebServOrdersTransactional/ServOrdersTransactional", "no_autorizacion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
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
