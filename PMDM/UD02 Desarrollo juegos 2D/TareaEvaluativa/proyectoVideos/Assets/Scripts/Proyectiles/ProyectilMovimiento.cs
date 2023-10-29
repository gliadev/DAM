using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class ProyectilMovimiento : MonoBehaviour
{
    // public float velocidad = 3.0f;
    public float fuerza = 100.0f;

    // Start is called before the first frame update
    void Start()
    {
        Rigidbody2D rigidbody2d = this.GetComponent<Rigidbody2D>();

        rigidbody2d.AddForce(transform.up * fuerza);
    }

    // Update is called once per frame
    void Update()
    {
        // transform.position = transform.position + transform.up * velocidad * Time.deltaTime;
    }
}
