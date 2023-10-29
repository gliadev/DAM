using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class PerroController : MonoBehaviour
{
    // Variables p�blicas
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

        // Cambiar de direcci�n si se alcanza la distancia l�mite
        if (Mathf.Abs(transform.position.x) >= distanciaLimite)
        {
            direccion = -direccion;
        }

        // Si el perro se mueve hacia la derecha y supera la distancia l�mite, destruirlo
        if (direccion == Vector3.right && transform.position.x >= distanciaLimite)
        {
            Destroy(gameObject);
        }
    }
}
