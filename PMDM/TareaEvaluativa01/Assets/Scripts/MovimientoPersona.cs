using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class MovimientoPersona : MonoBehaviour
{
    public float velocidad = 5f;  // Configura la velocidad de movimiento
    public float distanciaLimite = 10f;  // Configura la distancia m�xima que se puede mover

    private float direccion = 1f;  // Controla la direcci�n del movimiento (1 para derecha, -1 para izquierda)
    private float posicionInicialX;  // Guarda la posici�n inicial en el eje X

    // Se ejecuta una vez al inicio
    void Start()
    {
        // Guarda la posici�n inicial en el eje X
        posicionInicialX = transform.position.x;
    }

    // Se ejecuta una vez por frame
    void Update()
    {
        // Calcula la nueva posici�n en el eje X basada en la direcci�n, velocidad y tiempo desde el �ltimo frame
        float nuevaPosicionX = transform.position.x + direccion * velocidad * Time.deltaTime;

        // Verifica si se ha alcanzado la distancia l�mite
        if (Mathf.Abs(nuevaPosicionX - posicionInicialX) >= distanciaLimite)
        {
            // Cambia la direcci�n del movimiento si se alcanza la distancia l�mite
            direccion *= -1f;

            // Recalcula la nueva posici�n con la nueva direcci�n
            nuevaPosicionX = transform.position.x + direccion * velocidad * Time.deltaTime;
        }

        // Actualiza la posici�n del GameObject
        transform.position = new Vector3(nuevaPosicionX, transform.position.y, transform.position.z);
    }
}
