using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class MovimientoPollito : MonoBehaviour
{
    public GameObject target;  // Referencia al GameObject target
    public float ejeMayor = 5f;  // Semieje mayor de la elipse
    public float ejeMenor = 3f;  // Semieje menor de la elipse
    public float velocidad = 1f;  // Velocidad de movimiento del pollito

    private float angulo = 0f;  // Ángulo de giro inicial

    // Start is called before the first frame update
    void Start()
    {
        // Asegúrate de que el target está asignado en el inspector
        if (target == null)
        {
            Debug.LogError("No se ha asignado un target. Por favor, asigna un target en el Inspector.");
        }
    }

    // Update is called once per frame
    void Update()
    {
        // Incrementa el ángulo de giro
        angulo += velocidad * Time.deltaTime;

        // Calcula las nuevas coordenadas X e Z usando las ecuaciones paramétricas de una elipse
        float x = ejeMayor * Mathf.Cos(angulo);
        float z = ejeMenor * Mathf.Sin(angulo);

        // Calcula la nueva posición del pollito relativa al target
        Vector3 nuevaPosicion = target.transform.position + new Vector3(x, 0, z);

        // Aplica la nueva posición al pollito
        transform.position = nuevaPosicion;
    }
}
