/*export interface Job {
  id: number;
  name: string;
  hourly_rate: number;
  employer_id: number;
  description: string;
  category_id: number;
  skill_level: number;
}*/
export interface Job {
  id: number;
  summary: string;
  description: string;
  employer: number;
  applicants: number[];
  startDate: number;
  endDate: number;
  location: string;
  requiredSkills: number[];
  requiredXp: 0;
  status: string;
  payment: number;
  deadline: number;
}
