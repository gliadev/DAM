using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class MovimientoPersona : MonoBehaviour
{
    public float velocidad = 5f;  // Configura la velocidad de movimiento
    public float distanciaLimite = 10f;  // Configura la distancia máxima que se puede mover

    private float direccion = 1f;  // Controla la dirección del movimiento (1 para derecha, -1 para izquierda)
    private float posicionInicialX;  // Guarda la posición inicial en el eje X

    // Se ejecuta una vez al inicio
    void Start()
    {
        // Guarda la posición inicial en el eje X
        posicionInicialX = transform.position.x;
    }

    // Se ejecuta una vez por frame
    void Update()
    {
        // Calcula la nueva posición en el eje X basada en la dirección, velocidad y tiempo desde el último frame
        float nuevaPosicionX = transform.position.x + direccion * velocidad * Time.deltaTime;

        // Verifica si se ha alcanzado la distancia límite
        if (Mathf.Abs(nuevaPosicionX - posicionInicialX) >= distanciaLimite)
        {
            // Cambia la dirección del movimiento si se alcanza la distancia límite
            direccion *= -1f;

            // Recalcula la nueva posición con la nueva dirección
            nuevaPosicionX = transform.position.x + direccion * velocidad * Time.deltaTime;
        }

        // Actualiza la posición del GameObject
        transform.position = new Vector3(nuevaPosicionX, transform.position.y, transform.position.z);
    }
}
