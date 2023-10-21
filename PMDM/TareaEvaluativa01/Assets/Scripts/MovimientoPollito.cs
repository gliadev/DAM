using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class MovimientoPollito : MonoBehaviour
{
    public GameObject target;  // Referencia al GameObject target
    public float ejeMayor = 5f;  // Semieje mayor de la elipse
    public float ejeMenor = 3f;  // Semieje menor de la elipse
    public float velocidad = 1f;  // Velocidad de movimiento del pollito

    private float angulo = 0f;  // �ngulo de giro inicial

    // Start is called before the first frame update
    void Start()
    {
        // Aseg�rate de que el target est� asignado en el inspector
        if (target == null)
        {
            Debug.LogError("No se ha asignado un target. Por favor, asigna un target en el Inspector.");
        }
    }

    // Update is called once per frame
    void Update()
    {
        // Incrementa el �ngulo de giro
        angulo += velocidad * Time.deltaTime;

        // Calcula las nuevas coordenadas X e Z usando las ecuaciones param�tricas de una elipse
        float x = ejeMayor * Mathf.Cos(angulo);
        float z = ejeMenor * Mathf.Sin(angulo);

        // Calcula la nueva posici�n del pollito relativa al target
        Vector3 nuevaPosicion = target.transform.position + new Vector3(x, 0, z);

        // Aplica la nueva posici�n al pollito
        transform.position = nuevaPosicion;
    }
}
