export interface Product
{
     productId:number;
	 productName:string;
	 category:string;
	 rating:Map<string,string>;
	 review:Map<string,string>;
	 image:string;
	 price:string;
	 description: string;
	 specification:Map<string,string>;
}

export interface Products
{
    products : Array<Product>
}