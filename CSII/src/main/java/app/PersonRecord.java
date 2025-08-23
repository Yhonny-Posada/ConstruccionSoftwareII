package app;

import javax.swing.JOptionPane;

public class PersonRecord
{
	
	private void fillPersonalData(PersonClass _Pc_)
	{
	    _Pc_.setBloodType(JOptionPane.showInputDialog("Ingrese el tipo de sangre: "));
	    _Pc_.setBirthDate(JOptionPane.showInputDialog("Ingrese la fecha de nacimiento: "));
	    _Pc_.setMaritalStatus(JOptionPane.showInputDialog("Ingrese el estado civil: "));
	    _Pc_.setPersonAddress(JOptionPane.showInputDialog("Ingrese la dirección de residencia: "));
	    _Pc_.setPhoneNumber(JOptionPane.showInputDialog("Ingrese el número de teléfono: "));
	    _Pc_.setEmail(JOptionPane.showInputDialog("Ingrese el correo electrónico: "));
	    _Pc_.setEmergencyContactFullName(JOptionPane.showInputDialog("Ingrese el contacto de emergencia: "));
	    _Pc_.setRelationshipPatient(JOptionPane.showInputDialog("Relación con el contacto de emergencia: "));
	    _Pc_.setEmergencyPhoneNumber(JOptionPane.showInputDialog("Teléfono del contacto de emergencia: "));
	    _Pc_.setAllergies(JOptionPane.showInputDialog("¿Tiene alergias?: "));
	    _Pc_.setMedicalConditions(JOptionPane.showInputDialog("¿Condiciones médicas?: "));
	}
	
	public void RegisterPerson()
	{
		
		PersonClass _Pc_ = new PersonClass();
		
		_Pc_.setIdType(JOptionPane.showInputDialog("Ingrese el tipo de identificación: "));
		_Pc_.setIdNumber(JOptionPane.showInputDialog("Ingrese el número de identificación: "));
		_Pc_.setName(JOptionPane.showInputDialog("Ingrese los nombres completos: "));
		_Pc_.setLastName(JOptionPane.showInputDialog("Ingrese los apellidos completos: "));
		_Pc_.setGender(JOptionPane.showInputDialog("Ingrese el género con el que se identifique: "));
		
		// Space to validate the person's role

		int value = 0;
		boolean limiter = false;
		
		while (!limiter)
			try
			{
				
				value = Integer.parseInt(JOptionPane.showInputDialog("Su ingreso a la clínica es como: \n" +
						"1. Empleado\n" +
			            "2. Paciente\n" +
			            "3. Visitante\n" +
			            "4. Proveedor\n" +
			            "5. Consultor externo\n" +
			            
			            "\nSeleccione la opción correspondiente: "));
			
				if(value >= 1 && value <= 5)
					limiter = true;
				else
					JOptionPane.showInputDialog(null, "Por favor, ingrese un número que registra en el menú anterior entre 1 y 5.");
				
			}
			catch (NumberFormatException error)
			{
				
				JOptionPane.showInputDialog(null,"En este espacio solo se permiten números desde el 1 hasta el 5. Por favor, revise el menú anterior.");
				
			}
		
			if (value == 1)
			{
				
				_Pc_.setRelationshipClinic("Empleado");
				
				String profession = (JOptionPane.showInputDialog("Ingrese la profesión del empleado: "));
				_Pc_.setPersonCategory(profession);
				
				_Pc_.setPersonJobTitle(JOptionPane.showInputDialog("Ingrese el área en la que se desempeña: "));
				
				if (profession.equals("Medicina"))
				{
					
					_Pc_.setProfessionalLicenseNumber(JOptionPane.showInputDialog("Ingrese el número de licencia profesional: "));
					
				}
				
				_Pc_.setBloodType(JOptionPane.showInputDialog("Ingrese el tipo de sangre: "));
				_Pc_.setBirthDate(JOptionPane.showInputDialog("Ingrese la fecha de nacimiento: "));
				_Pc_.setMaritalStatus(JOptionPane.showInputDialog("Ingrese el estado civil: "));
				_Pc_.setPersonAddress(JOptionPane.showInputDialog("Ingrese la dirección de residencia: "));
				_Pc_.setPhoneNumber(JOptionPane.showInputDialog("Ingrese el número de teléfono: "));
				_Pc_.setEmail(JOptionPane.showInputDialog("Ingrese el correo electrónico: "));
				
				// Generation random of user name and password
					String id = _Pc_.getIdNumber();
					String name = _Pc_.getName();
					String lastName = _Pc_.getLastName();
	
					String user = (name.substring(0,2) + lastName.substring(0,2) + id.substring(id.length()-4)).toLowerCase();
					if(user.length() > 8) user = user.substring(0,8);
					_Pc_.setUsername(user);
	
					String pass = (name.substring(0,3) + lastName.substring(0,3) + id.substring(id.length()-4) + (int)(Math.random()*9000+1000));
					if(pass.length() > 16) pass = pass.substring(0,16);
					_Pc_.setSecurityKey(pass);
					
				_Pc_.setEmergencyContactFullName(JOptionPane.showInputDialog("Ingrese el nombre y apellido de un contacto de emergencia: "));
				_Pc_.setRelationshipPatient(JOptionPane.showInputDialog("Ingrese la relación que tiene con el contacto de emergencia: "));
				_Pc_.setEmergencyPhoneNumber(JOptionPane.showInputDialog("Ingrese el número telefónico del contacto de emergencia: "));
				_Pc_.setAllergies(JOptionPane.showInputDialog("Ingrese la información correspondiente si sufre de algún tipo de alergia: "));
				_Pc_.setMedicalConditions(JOptionPane.showInputDialog("Ingrese la información correspondiente si tiene alguna condición médica: "));
				
			}
			else if (value == 2)
			{
				
				_Pc_.setRelationshipClinic("Paciente");
				
				fillPersonalData(_Pc_);
				
			}	
			else if (value == 3)
			{

				_Pc_.setRelationshipClinic("Visitante");
				
				fillPersonalData(_Pc_);
				
			}
			else if (value == 4)
			{
				
				_Pc_.setRelationshipClinic("Proveedor");
				
				fillPersonalData(_Pc_);
				
			}	
			else if (value == 5)
			{
				
				_Pc_.setRelationshipClinic("Consultor externo");
				
				fillPersonalData(_Pc_);
				
			}		
			
	}

}
