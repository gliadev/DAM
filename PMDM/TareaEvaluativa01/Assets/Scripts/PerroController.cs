using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class PerroController : MonoBehaviour
{
    // Variables públicas
    public float velocidad = 5.0f;
    public float distanciaLimite = 10.0f;

    // Variables privadas
    private Vector3 direccion = Vector3.right;

    // Start is called before the first frame update
    void Start()
    {
        
    }

    // Update is called once per frame
    void Update()
    {
        // Mover el perro
        transform.Translate(direccion * velocidad * Time.deltaTime);

        // Cambiar de dirección si se alcanza la distancia límite
        if (Mathf.Abs(transform.position.x) >= distanciaLimite)
        {
            direccion = -direccion;
        }

        // Si el perro se mueve hacia la derecha y supera la distancia límite, destruirlo
        if (direccion == Vector3.right && transform.position.x >= distanciaLimite)
        {
            Destroy(gameObject);
        }
    }
}
