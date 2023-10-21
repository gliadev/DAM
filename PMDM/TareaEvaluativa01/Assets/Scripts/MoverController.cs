using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class MoverController : MonoBehaviour
{
    public float speed = 5f;
    public float distanceLimit = 100f;
    private int direction = 1;
    private Vector3 startingPosition;

    void Update()
    {
        if (startingPosition == Vector3.zero)
        {
            startingPosition = transform.position;
        }

        Vector3 newPosition = transform.position + Vector3.right * direction * speed * Time.deltaTime;

        if (Mathf.Abs(newPosition.x - startingPosition.x) >= distanceLimit)
        {
            direction *= -1;
            newPosition = transform.position + Vector3.right * direction * (Mathf.Abs(newPosition.x - startingPosition.x) - distanceLimit);
        }

        transform.position = newPosition;
    }
}