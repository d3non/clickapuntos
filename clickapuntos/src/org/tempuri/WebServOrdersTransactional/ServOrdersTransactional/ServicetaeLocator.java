/**
 * ServicetaeLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri.WebServOrdersTransactional.ServOrdersTransactional;

public class ServicetaeLocator extends org.apache.axis.client.Service implements org.tempuri.WebServOrdersTransactional.ServOrdersTransactional.Servicetae {

    public ServicetaeLocator() {
    }


    public ServicetaeLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public ServicetaeLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for ServicetaeSoap
    private java.lang.String ServicetaeSoap_address = "http://201.144.219.232/MTCenter.WS.TAE/Servicetae.asmx";

    public java.lang.String getServicetaeSoapAddress() {
        return ServicetaeSoap_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String ServicetaeSoapWSDDServiceName = "ServicetaeSoap";

    public java.lang.String getServicetaeSoapWSDDServiceName() {
        return ServicetaeSoapWSDDServiceName;
    }

    public void setServicetaeSoapWSDDServiceName(java.lang.String name) {
        ServicetaeSoapWSDDServiceName = name;
    }

    public org.tempuri.WebServOrdersTransactional.ServOrdersTransactional.ServicetaeSoap getServicetaeSoap() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(ServicetaeSoap_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getServicetaeSoap(endpoint);
    }

    public org.tempuri.WebServOrdersTransactional.ServOrdersTransactional.ServicetaeSoap getServicetaeSoap(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            org.tempuri.WebServOrdersTransactional.ServOrdersTransactional.ServicetaeSoapStub _stub = new org.tempuri.WebServOrdersTransactional.ServOrdersTransactional.ServicetaeSoapStub(portAddress, this);
            _stub.setPortName(getServicetaeSoapWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setServicetaeSoapEndpointAddress(java.lang.String address) {
        ServicetaeSoap_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (org.tempuri.WebServOrdersTransactional.ServOrdersTransactional.ServicetaeSoap.class.isAssignableFrom(serviceEndpointInterface)) {
                org.tempuri.WebServOrdersTransactional.ServOrdersTransactional.ServicetaeSoapStub _stub = new org.tempuri.WebServOrdersTransactional.ServOrdersTransactional.ServicetaeSoapStub(new java.net.URL(ServicetaeSoap_address), this);
                _stub.setPortName(getServicetaeSoapWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("ServicetaeSoap".equals(inputPortName)) {
            return getServicetaeSoap();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://tempuri.org/WebServOrdersTransactional/ServOrdersTransactional", "Servicetae");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://tempuri.org/WebServOrdersTransactional/ServOrdersTransactional", "ServicetaeSoap"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("ServicetaeSoap".equals(portName)) {
            setServicetaeSoapEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
