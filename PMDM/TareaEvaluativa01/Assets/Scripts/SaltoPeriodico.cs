using System.Collections;
using UnityEngine;

public class SaltoPeriodico : MonoBehaviour
{
    public float fuerzaDeSalto = 20f;  // Fuerza con la que se realizará el salto
    public float intervaloDeSalto = 3f;  // Intervalo de tiempo entre saltos en segundos
    public LayerMask capaDelSuelo;  // Capa que representa el suelo
    public float alturaDelRayo = 0.1f;  // Altura del rayo para detectar el suelo

    private Rigidbody rb;  // Referencia al componente Rigidbody del GameObject
    private bool estaEnElSuelo;  // Variable para verificar si el personaje está en el suelo

    // Se ejecuta una vez al inicio
    void Start()
    {
        // Obtén la referencia al componente Rigidbody
        rb = GetComponent<Rigidbody>();

        // Verifica si el componente Rigidbody está adjunto
        if (rb == null)
        {
            Debug.LogError("No se encontró un componente Rigidbody. Asegúrate de adjuntar un componente Rigidbody al GameObject.");
            return;
        }

        // Inicia la corrutina para manejar los saltos periódicos
        StartCoroutine(SaltosPeriodicos());
    }

    // Se ejecuta una vez por frame
    void Update()
    {
        // Verifica si el personaje está en el suelo
        estaEnElSuelo = Physics.Raycast(transform.position, Vector3.down, alturaDelRayo, capaDelSuelo);
    }

    IEnumerator SaltosPeriodicos()
    {
        while (true)
        {
            // Espera el intervalo de tiempo especificado
            yield return new WaitForSeconds(intervaloDeSalto);

            // Si el personaje está en el suelo, aplica una fuerza hacia arriba para hacer que el GameObject salte
            if (estaEnElSuelo)
            {
                rb.velocity = new Vector3(rb.velocity.x, fuerzaDeSalto, rb.velocity.z);  // Aplica la fuerza de salto
            }
        }
    }
}