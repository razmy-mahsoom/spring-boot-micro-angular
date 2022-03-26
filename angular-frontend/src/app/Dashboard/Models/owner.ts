export class Owner {
  id?:number;
  userId?:string;
  firstName?:string;
  lastName?:string;
  gender?:string;
  governmentId?:string;
  countryCode?:string;
  contactNumber?:string
  address?:string;
  city?:string;
  country?:string;
  postalCode?:string;
  dateOfBirth?:string;
  createdAt?:string;
  isProfileCompleted?:boolean;


  constructor(id: number, userId: string, firstName: string, lastName: string, gender: string, governmentId: string, countryCode: string, contactNumber: string, address: string, city: string, country: string, postalCode: string, dateOfBirth: string, createdAt: string, isProfileCompleted: boolean) {
    this.id = id;
    this.userId = userId;
    this.firstName = firstName;
    this.lastName = lastName;
    this.gender = gender;
    this.governmentId = governmentId;
    this.countryCode = countryCode;
    this.contactNumber = contactNumber;
    this.address = address;
    this.city = city;
    this.country = country;
    this.postalCode = postalCode;
    this.dateOfBirth = dateOfBirth;
    this.createdAt = createdAt;
    this.isProfileCompleted = isProfileCompleted;
  }
}
