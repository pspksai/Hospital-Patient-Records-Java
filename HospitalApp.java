package com.hospital;

import java.util.ArrayList;
import java.util.Scanner;
import com.hospital.Patient;



public class HospitalApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Patient> patients = new ArrayList<>();
        int patientIdCounter = 1000;

        int choice;

        while (true) {

            System.out.println("\n=================================");
            System.out.println("  HOSPITAL PATIENT RECORD SYSTEM ");
            System.out.println("=================================");

            System.out.println("1. Add Patient");
            System.out.println("2. View All Patients");
            System.out.println("3. Search Patient by ID");
            System.out.println("4. Delete Patient");
            System.out.println("5. Update Patient Info");
            System.out.println("6. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {

            case 1:
                patientIdCounter++;

                System.out.print("Enter Patient Name: ");
                sc.nextLine(); // clear buffer
                String name = sc.nextLine();

                System.out.print("Enter Age: ");
                int age = sc.nextInt();

                System.out.print("Enter Gender: ");
                sc.nextLine(); // clear buffer
                String gender = sc.nextLine();

                System.out.print("Enter Blood Group: ");
                String bloodGroup = sc.nextLine();

                System.out.print("Enter Ailment: ");
                String ailment = sc.nextLine();

                // Create Patient object
                Patient patient = new Patient(
                        patientIdCounter,
                        name,
                        age,
                        gender,
                        bloodGroup,
                        ailment
                );

                // Add to ArrayList
                patients.add(patient);

                System.out.println("✅ Patient added successfully!");
                System.out.println("Generated Patient ID: " + patientIdCounter);

                break;


            case 2:
                if (patients.isEmpty()) {
                    System.out.println("❌ No patient records found.");
                } else {
                    System.out.println("\n----- Patient Records -----");
                    for (Patient p : patients) {
                        System.out.println("Patient ID   : " + p.getPatientId());
                        System.out.println("Name         : " + p.getName());
                        System.out.println("Age          : " + p.getAge());
                        System.out.println("Gender       : " + p.getGender());
                        System.out.println("Blood Group  : " + p.getBloodGroup());
                        System.out.println("Ailment      : " + p.getAilment());
                        System.out.println("---------------------------");
                    }
                }
                break;


            case 3:
                System.out.print("Enter Patient ID to search: ");
                int searchId = sc.nextInt();

                boolean found = false;

                for (Patient p : patients) {
                    if (p.getPatientId() == searchId) {
                        System.out.println("\n✅ Patient Found");
                        System.out.println("Patient ID   : " + p.getPatientId());
                        System.out.println("Name         : " + p.getName());
                        System.out.println("Age          : " + p.getAge());
                        System.out.println("Gender       : " + p.getGender());
                        System.out.println("Blood Group  : " + p.getBloodGroup());
                        System.out.println("Ailment      : " + p.getAilment());
                        found = true;
                        break;
                    }
                }

                if (!found) {
                    System.out.println("❌ Patient with ID " + searchId + " not found.");
                }
                break;

            case 4:
                System.out.print("Enter Patient ID to delete: ");
                int deleteId = sc.nextInt();

                boolean deleted = false;

                for (int i = 0; i < patients.size(); i++) {
                    if (patients.get(i).getPatientId() == deleteId) {
                        patients.remove(i);
                        deleted = true;
                        break;
                    }
                }

                if (deleted) {
                    System.out.println("✅ Patient record deleted successfully.");
                } else {
                    System.out.println("❌ Patient with ID " + deleteId + " not found.");
                }
                break;
                
            case 5:
                System.out.print("Enter Patient ID to update: ");
                int updateId = sc.nextInt();

                boolean updated = false;

                for (Patient p : patients) {
                    if (p.getPatientId() == updateId) {

                        sc.nextLine(); // clear buffer

                        System.out.print("Enter New Name: ");
                        String newName = sc.nextLine();

                        System.out.print("Enter New Age: ");
                        int newAge = sc.nextInt();

                        sc.nextLine(); // clear buffer
                        System.out.print("Enter New Gender: ");
                        String newGender = sc.nextLine();

                        System.out.print("Enter New Blood Group: ");
                        String newBloodGroup = sc.nextLine();

                        System.out.print("Enter New Ailment: ");
                        String newAilment = sc.nextLine();

                        // Updating values using setters
                        p.setName(newName);
                        p.setAge(newAge);
                        p.setGender(newGender);
                        p.setBloodGroup(newBloodGroup);
                        p.setAilment(newAilment);

                        updated = true;
                        System.out.println("✅ Patient details updated successfully.");
                        break;
                    }
                }

                if (!updated) {
                    System.out.println("❌ Patient with ID " + updateId + " not found.");
                }
                break;



                case 6:
                    System.out.println("Thank you! Exiting...");
                    sc.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}
