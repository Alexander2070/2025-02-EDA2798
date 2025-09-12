package service;

import domain.Cuenta;
import java.util.List;

public interface IServiceCuenta {
    List<Cuenta> obtenerCuentas(); // Implementar
    Cuenta obtenernumeroCuenta(String numeroCuenta); // Implementar
    void crearCuenta(Cuenta cuenta); // Implementar
}
