package org.tempuri.WebServOrdersTransactional.ServOrdersTransactional;

public class ServicetaeSoapProxy implements org.tempuri.WebServOrdersTransactional.ServOrdersTransactional.ServicetaeSoap {
  private String _endpoint = null;
  private org.tempuri.WebServOrdersTransactional.ServOrdersTransactional.ServicetaeSoap servicetaeSoap = null;
  
  public ServicetaeSoapProxy() {
    _initServicetaeSoapProxy();
  }
  
  public ServicetaeSoapProxy(String endpoint) {
    _endpoint = endpoint;
    _initServicetaeSoapProxy();
  }
  
  private void _initServicetaeSoapProxy() {
    try {
      servicetaeSoap = (new org.tempuri.WebServOrdersTransactional.ServOrdersTransactional.ServicetaeLocator()).getServicetaeSoap();
      if (servicetaeSoap != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)servicetaeSoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)servicetaeSoap)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (servicetaeSoap != null)
      ((javax.xml.rpc.Stub)servicetaeSoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public org.tempuri.WebServOrdersTransactional.ServOrdersTransactional.ServicetaeSoap getServicetaeSoap() {
    if (servicetaeSoap == null)
      _initServicetaeSoapProxy();
    return servicetaeSoap;
  }
  
  public org.tempuri.WebServOrdersTransactional.ServOrdersTransactional.OutputRecarga recarga(org.tempuri.WebServOrdersTransactional.ServOrdersTransactional.InputRecarga inputRecarga) throws java.rmi.RemoteException{
    if (servicetaeSoap == null)
      _initServicetaeSoapProxy();
    return servicetaeSoap.recarga(inputRecarga);
  }
  
  public org.tempuri.WebServOrdersTransactional.ServOrdersTransactional.OutputReverso reverso(org.tempuri.WebServOrdersTransactional.ServOrdersTransactional.InputReverso inputReverso) throws java.rmi.RemoteException{
    if (servicetaeSoap == null)
      _initServicetaeSoapProxy();
    return servicetaeSoap.reverso(inputReverso);
  }
  
  public org.tempuri.WebServOrdersTransactional.ServOrdersTransactional.OutputConsulta consulta(org.tempuri.WebServOrdersTransactional.ServOrdersTransactional.InputConsulta inputConsulta) throws java.rmi.RemoteException{
    if (servicetaeSoap == null)
      _initServicetaeSoapProxy();
    return servicetaeSoap.consulta(inputConsulta);
  }
  
  public org.tempuri.WebServOrdersTransactional.ServOrdersTransactional.OutputSaldo saldo(org.tempuri.WebServOrdersTransactional.ServOrdersTransactional.InputSaldo inputSaldo) throws java.rmi.RemoteException{
    if (servicetaeSoap == null)
      _initServicetaeSoapProxy();
    return servicetaeSoap.saldo(inputSaldo);
  }
  
  
}