using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class ProyectilAlcanzaEnemigo : MonoBehaviour
{
    // Start is called before the first frame update
    void Start()
    {
        
    }

    // Update is called once per frame
    void Update()
    {
        
    }

    // Colisión con un enemigo.Destruye el enemigo y el proyectil.
    void OnTriggerEnter2D(Collider2D other)
    {
        Debug.Log("Se ha producido un trigger con " + other.gameObject);

        if (other.gameObject.CompareTag("Enemy"))
        {
            Destroy(other.gameObject);
        }
        if (other.name != "Player")
        {
            Destroy(this.gameObject);
        }
    }
}
