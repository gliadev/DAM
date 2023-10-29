using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class ProyectilRigidBody : MonoBehaviour
{
    public float fuerza = 100.0f;


    // Start is called before the first frame update
    void Start()
    {
        Rigidbody2D rigidbody2d = GetComponent<Rigidbody2D>();

        rigidbody2d.AddForce(transform.up * fuerza);
    }

    // Update is called once per frame
    void Update()
    {

    }
}
