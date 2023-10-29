using System.Collections;
using UnityEngine;

public class GestorDeAlimentos : MonoBehaviour
{
    public GameObject prefabDeAlimento;
    public float tiempoDeAparicion = 5f;
    public float tiempoDeDesaparicion = 10f;
    public Vector3 rangoDePosiciones = new Vector3(10f, 0f, 10f);

    void Start()
    {
        StartCoroutine(CrearAlimentos());
    }

    IEnumerator CrearAlimentos()
    {
        while (true)
        {
            float x = Random.Range(-rangoDePosiciones.x, rangoDePosiciones.x);
            float z = Random.Range(-rangoDePosiciones.z, rangoDePosiciones.z);
            Vector3 posicionAleatoria = new Vector3(x, 0, z);

            GameObject alimento = Instantiate(prefabDeAlimento, posicionAleatoria, Quaternion.identity);

            Debug.Log("Alimento creado: " + alimento.name);  // Log al crear alimento

            yield return new WaitForSeconds(tiempoDeDesaparicion);  // Espera antes de destruir alimento

            if (alimento != null)  // Verifica si el alimento aún existe
            {
                Destroy(alimento);
                Debug.Log("Alimento destruido: " + alimento.name);  // Log al destruir alimento
            }

            yield return new WaitForSeconds(tiempoDeAparicion - tiempoDeDesaparicion);  // Espera antes de crear otro alimento
        }
    }
}